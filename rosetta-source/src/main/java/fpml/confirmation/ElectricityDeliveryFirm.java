package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ElectricityDeliveryFirm;
import fpml.confirmation.ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder;
import fpml.confirmation.ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilderImpl;
import fpml.confirmation.ElectricityDeliveryFirm.ElectricityDeliveryFirmImpl;
import fpml.confirmation.meta.ElectricityDeliveryFirmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery obligation options specific to a firm transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDeliveryFirm", builder=ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilderImpl.class, version="${project.version}")
public interface ElectricityDeliveryFirm extends RosettaModelObject {

	ElectricityDeliveryFirmMeta metaData = new ElectricityDeliveryFirmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, indicates that the buyer and seller should be excused of their delivery obligations when such performance is prevented by Force Majeure. For EEI transactions, this would indicate &quot;Firm (LD)&quot; If false, indicates that the buyer and seller should not be excused of their delivery obligations when such performance is prevented by Force Majeure. For EEI transactions, this would indicate &quot;Firm (No Force Majeure)&quot;
	 */
	Boolean getForceMajeure();

	/*********************** Build Methods  ***********************/
	ElectricityDeliveryFirm build();
	
	ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder toBuilder();
	
	static ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder builder() {
		return new ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliveryFirm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliveryFirm> getType() {
		return ElectricityDeliveryFirm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryFirmBuilder extends ElectricityDeliveryFirm, RosettaModelObjectBuilder {
		ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder setForceMajeure(Boolean forceMajeure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
		}
		

		ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliveryFirm  ***********************/
	class ElectricityDeliveryFirmImpl implements ElectricityDeliveryFirm {
		private final Boolean forceMajeure;
		
		protected ElectricityDeliveryFirmImpl(ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder builder) {
			this.forceMajeure = builder.getForceMajeure();
		}
		
		@Override
		@RosettaAttribute("forceMajeure")
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		public ElectricityDeliveryFirm build() {
			return this;
		}
		
		@Override
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder toBuilder() {
			ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder builder) {
			ofNullable(getForceMajeure()).ifPresent(builder::setForceMajeure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryFirm _that = getType().cast(o);
		
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryFirm {" +
				"forceMajeure=" + this.forceMajeure +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliveryFirm  ***********************/
	class ElectricityDeliveryFirmBuilderImpl implements ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder {
	
		protected Boolean forceMajeure;
	
		public ElectricityDeliveryFirmBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("forceMajeure")
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		@RosettaAttribute("forceMajeure")
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder setForceMajeure(Boolean forceMajeure) {
			this.forceMajeure = forceMajeure==null?null:forceMajeure;
			return this;
		}
		
		@Override
		public ElectricityDeliveryFirm build() {
			return new ElectricityDeliveryFirm.ElectricityDeliveryFirmImpl(this);
		}
		
		@Override
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getForceMajeure()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder o = (ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder) other;
			
			
			merger.mergeBasic(getForceMajeure(), o.getForceMajeure(), this::setForceMajeure);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryFirm _that = getType().cast(o);
		
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryFirmBuilder {" +
				"forceMajeure=" + this.forceMajeure +
			'}';
		}
	}
}

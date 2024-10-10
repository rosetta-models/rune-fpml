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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySystemFirm;
import fpml.confirmation.ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder;
import fpml.confirmation.ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl;
import fpml.confirmation.ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmImpl;
import fpml.confirmation.meta.ElectricityDeliverySystemFirmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery obligation options specific to a system firm transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDeliverySystemFirm", builder=ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl.class, version="${project.version}")
public interface ElectricityDeliverySystemFirm extends RosettaModelObject {

	ElectricityDeliverySystemFirmMeta metaData = new ElectricityDeliverySystemFirmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that the trade is for a System Firm product. Should always be set to &quot;true&quot;.
	 */
	Boolean getApplicable();
	CommodityDeliveryPoint getSystem();

	/*********************** Build Methods  ***********************/
	ElectricityDeliverySystemFirm build();
	
	ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder();
	
	static ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder() {
		return new ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliverySystemFirm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliverySystemFirm> getType() {
		return ElectricityDeliverySystemFirm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("system"), processor, CommodityDeliveryPoint.class, getSystem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliverySystemFirmBuilder extends ElectricityDeliverySystemFirm, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateSystem();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getSystem();
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setApplicable(Boolean applicable);
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setSystem(CommodityDeliveryPoint system);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("system"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getSystem());
		}
		

		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliverySystemFirm  ***********************/
	class ElectricityDeliverySystemFirmImpl implements ElectricityDeliverySystemFirm {
		private final Boolean applicable;
		private final CommodityDeliveryPoint system;
		
		protected ElectricityDeliverySystemFirmImpl(ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder) {
			this.applicable = builder.getApplicable();
			this.system = ofNullable(builder.getSystem()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("system")
		public CommodityDeliveryPoint getSystem() {
			return system;
		}
		
		@Override
		public ElectricityDeliverySystemFirm build() {
			return this;
		}
		
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder() {
			ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getSystem()).ifPresent(builder::setSystem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySystemFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(system, _that.getSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (system != null ? system.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySystemFirm {" +
				"applicable=" + this.applicable + ", " +
				"system=" + this.system +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliverySystemFirm  ***********************/
	class ElectricityDeliverySystemFirmBuilderImpl implements ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder system;
	
		public ElectricityDeliverySystemFirmBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("system")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getSystem() {
			return system;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateSystem() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (system!=null) {
				result = system;
			}
			else {
				result = system = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("system")
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder setSystem(CommodityDeliveryPoint system) {
			this.system = system==null?null:system.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliverySystemFirm build() {
			return new ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmImpl(this);
		}
		
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder prune() {
			if (system!=null && !system.prune().hasData()) system = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getSystem()!=null && getSystem().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder o = (ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder) other;
			
			merger.mergeRosetta(getSystem(), o.getSystem(), this::setSystem);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliverySystemFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(system, _that.getSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (system != null ? system.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliverySystemFirmBuilder {" +
				"applicable=" + this.applicable + ", " +
				"system=" + this.system +
			'}';
		}
	}
}

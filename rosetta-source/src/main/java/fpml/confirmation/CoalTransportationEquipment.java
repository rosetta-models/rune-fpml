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
import fpml.confirmation.CoalTransportationEquipment;
import fpml.confirmation.CoalTransportationEquipment.CoalTransportationEquipmentBuilder;
import fpml.confirmation.CoalTransportationEquipment.CoalTransportationEquipmentBuilderImpl;
import fpml.confirmation.CoalTransportationEquipment.CoalTransportationEquipmentImpl;
import fpml.confirmation.meta.CoalTransportationEquipmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the methods by which coal may be transported.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalTransportationEquipment", builder=CoalTransportationEquipment.CoalTransportationEquipmentBuilderImpl.class, version="${project.version}")
public interface CoalTransportationEquipment extends RosettaModelObject {

	CoalTransportationEquipmentMeta metaData = new CoalTransportationEquipmentMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityCoalTransportationEquipmentScheme();

	/*********************** Build Methods  ***********************/
	CoalTransportationEquipment build();
	
	CoalTransportationEquipment.CoalTransportationEquipmentBuilder toBuilder();
	
	static CoalTransportationEquipment.CoalTransportationEquipmentBuilder builder() {
		return new CoalTransportationEquipment.CoalTransportationEquipmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalTransportationEquipment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalTransportationEquipment> getType() {
		return CoalTransportationEquipment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityCoalTransportationEquipmentScheme"), String.class, getCommodityCoalTransportationEquipmentScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalTransportationEquipmentBuilder extends CoalTransportationEquipment, RosettaModelObjectBuilder {
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder setValue(String value);
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder setCommodityCoalTransportationEquipmentScheme(String commodityCoalTransportationEquipmentScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityCoalTransportationEquipmentScheme"), String.class, getCommodityCoalTransportationEquipmentScheme(), this);
		}
		

		CoalTransportationEquipment.CoalTransportationEquipmentBuilder prune();
	}

	/*********************** Immutable Implementation of CoalTransportationEquipment  ***********************/
	class CoalTransportationEquipmentImpl implements CoalTransportationEquipment {
		private final String value;
		private final String commodityCoalTransportationEquipmentScheme;
		
		protected CoalTransportationEquipmentImpl(CoalTransportationEquipment.CoalTransportationEquipmentBuilder builder) {
			this.value = builder.getValue();
			this.commodityCoalTransportationEquipmentScheme = builder.getCommodityCoalTransportationEquipmentScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalTransportationEquipmentScheme")
		public String getCommodityCoalTransportationEquipmentScheme() {
			return commodityCoalTransportationEquipmentScheme;
		}
		
		@Override
		public CoalTransportationEquipment build() {
			return this;
		}
		
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder toBuilder() {
			CoalTransportationEquipment.CoalTransportationEquipmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalTransportationEquipment.CoalTransportationEquipmentBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityCoalTransportationEquipmentScheme()).ifPresent(builder::setCommodityCoalTransportationEquipmentScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalTransportationEquipment _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalTransportationEquipmentScheme, _that.getCommodityCoalTransportationEquipmentScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalTransportationEquipmentScheme != null ? commodityCoalTransportationEquipmentScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalTransportationEquipment {" +
				"value=" + this.value + ", " +
				"commodityCoalTransportationEquipmentScheme=" + this.commodityCoalTransportationEquipmentScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalTransportationEquipment  ***********************/
	class CoalTransportationEquipmentBuilderImpl implements CoalTransportationEquipment.CoalTransportationEquipmentBuilder {
	
		protected String value;
		protected String commodityCoalTransportationEquipmentScheme;
	
		public CoalTransportationEquipmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalTransportationEquipmentScheme")
		public String getCommodityCoalTransportationEquipmentScheme() {
			return commodityCoalTransportationEquipmentScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalTransportationEquipmentScheme")
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder setCommodityCoalTransportationEquipmentScheme(String commodityCoalTransportationEquipmentScheme) {
			this.commodityCoalTransportationEquipmentScheme = commodityCoalTransportationEquipmentScheme==null?null:commodityCoalTransportationEquipmentScheme;
			return this;
		}
		
		@Override
		public CoalTransportationEquipment build() {
			return new CoalTransportationEquipment.CoalTransportationEquipmentImpl(this);
		}
		
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityCoalTransportationEquipmentScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalTransportationEquipment.CoalTransportationEquipmentBuilder o = (CoalTransportationEquipment.CoalTransportationEquipmentBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityCoalTransportationEquipmentScheme(), o.getCommodityCoalTransportationEquipmentScheme(), this::setCommodityCoalTransportationEquipmentScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalTransportationEquipment _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalTransportationEquipmentScheme, _that.getCommodityCoalTransportationEquipmentScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalTransportationEquipmentScheme != null ? commodityCoalTransportationEquipmentScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalTransportationEquipmentBuilder {" +
				"value=" + this.value + ", " +
				"commodityCoalTransportationEquipmentScheme=" + this.commodityCoalTransportationEquipmentScheme +
			'}';
		}
	}
}

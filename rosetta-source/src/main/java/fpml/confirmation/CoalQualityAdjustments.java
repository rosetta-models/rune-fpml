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
import fpml.confirmation.CoalQualityAdjustments;
import fpml.confirmation.CoalQualityAdjustments.CoalQualityAdjustmentsBuilder;
import fpml.confirmation.CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl;
import fpml.confirmation.CoalQualityAdjustments.CoalQualityAdjustmentsImpl;
import fpml.confirmation.meta.CoalQualityAdjustmentsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the quality adjustment formulae for a physically settled coal trade.
 * @version ${project.version}
 */
@RosettaDataType(value="CoalQualityAdjustments", builder=CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl.class, version="${project.version}")
public interface CoalQualityAdjustments extends RosettaModelObject {

	CoalQualityAdjustmentsMeta metaData = new CoalQualityAdjustmentsMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityCoalQualityAdjustmentsScheme();

	/*********************** Build Methods  ***********************/
	CoalQualityAdjustments build();
	
	CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder();
	
	static CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder() {
		return new CoalQualityAdjustments.CoalQualityAdjustmentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalQualityAdjustments> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalQualityAdjustments> getType() {
		return CoalQualityAdjustments.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityCoalQualityAdjustmentsScheme"), String.class, getCommodityCoalQualityAdjustmentsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalQualityAdjustmentsBuilder extends CoalQualityAdjustments, RosettaModelObjectBuilder {
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setValue(String value);
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setCommodityCoalQualityAdjustmentsScheme(String commodityCoalQualityAdjustmentsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityCoalQualityAdjustmentsScheme"), String.class, getCommodityCoalQualityAdjustmentsScheme(), this);
		}
		

		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder prune();
	}

	/*********************** Immutable Implementation of CoalQualityAdjustments  ***********************/
	class CoalQualityAdjustmentsImpl implements CoalQualityAdjustments {
		private final String value;
		private final String commodityCoalQualityAdjustmentsScheme;
		
		protected CoalQualityAdjustmentsImpl(CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder) {
			this.value = builder.getValue();
			this.commodityCoalQualityAdjustmentsScheme = builder.getCommodityCoalQualityAdjustmentsScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		public String getCommodityCoalQualityAdjustmentsScheme() {
			return commodityCoalQualityAdjustmentsScheme;
		}
		
		@Override
		public CoalQualityAdjustments build() {
			return this;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalQualityAdjustments.CoalQualityAdjustmentsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityCoalQualityAdjustmentsScheme()).ifPresent(builder::setCommodityCoalQualityAdjustmentsScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalQualityAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalQualityAdjustmentsScheme, _that.getCommodityCoalQualityAdjustmentsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalQualityAdjustmentsScheme != null ? commodityCoalQualityAdjustmentsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalQualityAdjustments {" +
				"value=" + this.value + ", " +
				"commodityCoalQualityAdjustmentsScheme=" + this.commodityCoalQualityAdjustmentsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalQualityAdjustments  ***********************/
	class CoalQualityAdjustmentsBuilderImpl implements CoalQualityAdjustments.CoalQualityAdjustmentsBuilder {
	
		protected String value;
		protected String commodityCoalQualityAdjustmentsScheme;
	
		public CoalQualityAdjustmentsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		public String getCommodityCoalQualityAdjustmentsScheme() {
			return commodityCoalQualityAdjustmentsScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalQualityAdjustmentsScheme")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder setCommodityCoalQualityAdjustmentsScheme(String commodityCoalQualityAdjustmentsScheme) {
			this.commodityCoalQualityAdjustmentsScheme = commodityCoalQualityAdjustmentsScheme==null?null:commodityCoalQualityAdjustmentsScheme;
			return this;
		}
		
		@Override
		public CoalQualityAdjustments build() {
			return new CoalQualityAdjustments.CoalQualityAdjustmentsImpl(this);
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityCoalQualityAdjustmentsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder o = (CoalQualityAdjustments.CoalQualityAdjustmentsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityCoalQualityAdjustmentsScheme(), o.getCommodityCoalQualityAdjustmentsScheme(), this::setCommodityCoalQualityAdjustmentsScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalQualityAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalQualityAdjustmentsScheme, _that.getCommodityCoalQualityAdjustmentsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalQualityAdjustmentsScheme != null ? commodityCoalQualityAdjustmentsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalQualityAdjustmentsBuilder {" +
				"value=" + this.value + ", " +
				"commodityCoalQualityAdjustmentsScheme=" + this.commodityCoalQualityAdjustmentsScheme +
			'}';
		}
	}
}

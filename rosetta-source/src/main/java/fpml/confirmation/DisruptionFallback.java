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
import fpml.confirmation.DisruptionFallback;
import fpml.confirmation.DisruptionFallback.DisruptionFallbackBuilder;
import fpml.confirmation.DisruptionFallback.DisruptionFallbackBuilderImpl;
import fpml.confirmation.DisruptionFallback.DisruptionFallbackImpl;
import fpml.confirmation.meta.DisruptionFallbackMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A Disruption Fallback.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DisruptionFallback", builder=DisruptionFallback.DisruptionFallbackBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DisruptionFallback extends RosettaModelObject {

	DisruptionFallbackMeta metaData = new DisruptionFallbackMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityMarketDisruptionFallbackScheme();

	/*********************** Build Methods  ***********************/
	DisruptionFallback build();
	
	DisruptionFallback.DisruptionFallbackBuilder toBuilder();
	
	static DisruptionFallback.DisruptionFallbackBuilder builder() {
		return new DisruptionFallback.DisruptionFallbackBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DisruptionFallback> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DisruptionFallback> getType() {
		return DisruptionFallback.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMarketDisruptionFallbackScheme"), String.class, getCommodityMarketDisruptionFallbackScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DisruptionFallbackBuilder extends DisruptionFallback, RosettaModelObjectBuilder {
		DisruptionFallback.DisruptionFallbackBuilder setValue(String value);
		DisruptionFallback.DisruptionFallbackBuilder setCommodityMarketDisruptionFallbackScheme(String commodityMarketDisruptionFallbackScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMarketDisruptionFallbackScheme"), String.class, getCommodityMarketDisruptionFallbackScheme(), this);
		}
		

		DisruptionFallback.DisruptionFallbackBuilder prune();
	}

	/*********************** Immutable Implementation of DisruptionFallback  ***********************/
	class DisruptionFallbackImpl implements DisruptionFallback {
		private final String value;
		private final String commodityMarketDisruptionFallbackScheme;
		
		protected DisruptionFallbackImpl(DisruptionFallback.DisruptionFallbackBuilder builder) {
			this.value = builder.getValue();
			this.commodityMarketDisruptionFallbackScheme = builder.getCommodityMarketDisruptionFallbackScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMarketDisruptionFallbackScheme")
		public String getCommodityMarketDisruptionFallbackScheme() {
			return commodityMarketDisruptionFallbackScheme;
		}
		
		@Override
		public DisruptionFallback build() {
			return this;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder toBuilder() {
			DisruptionFallback.DisruptionFallbackBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DisruptionFallback.DisruptionFallbackBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMarketDisruptionFallbackScheme()).ifPresent(builder::setCommodityMarketDisruptionFallbackScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisruptionFallback _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMarketDisruptionFallbackScheme, _that.getCommodityMarketDisruptionFallbackScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMarketDisruptionFallbackScheme != null ? commodityMarketDisruptionFallbackScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisruptionFallback {" +
				"value=" + this.value + ", " +
				"commodityMarketDisruptionFallbackScheme=" + this.commodityMarketDisruptionFallbackScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DisruptionFallback  ***********************/
	class DisruptionFallbackBuilderImpl implements DisruptionFallback.DisruptionFallbackBuilder {
	
		protected String value;
		protected String commodityMarketDisruptionFallbackScheme;
	
		public DisruptionFallbackBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMarketDisruptionFallbackScheme")
		public String getCommodityMarketDisruptionFallbackScheme() {
			return commodityMarketDisruptionFallbackScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public DisruptionFallback.DisruptionFallbackBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityMarketDisruptionFallbackScheme")
		public DisruptionFallback.DisruptionFallbackBuilder setCommodityMarketDisruptionFallbackScheme(String commodityMarketDisruptionFallbackScheme) {
			this.commodityMarketDisruptionFallbackScheme = commodityMarketDisruptionFallbackScheme==null?null:commodityMarketDisruptionFallbackScheme;
			return this;
		}
		
		@Override
		public DisruptionFallback build() {
			return new DisruptionFallback.DisruptionFallbackImpl(this);
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMarketDisruptionFallbackScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DisruptionFallback.DisruptionFallbackBuilder o = (DisruptionFallback.DisruptionFallbackBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMarketDisruptionFallbackScheme(), o.getCommodityMarketDisruptionFallbackScheme(), this::setCommodityMarketDisruptionFallbackScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisruptionFallback _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMarketDisruptionFallbackScheme, _that.getCommodityMarketDisruptionFallbackScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMarketDisruptionFallbackScheme != null ? commodityMarketDisruptionFallbackScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisruptionFallbackBuilder {" +
				"value=" + this.value + ", " +
				"commodityMarketDisruptionFallbackScheme=" + this.commodityMarketDisruptionFallbackScheme +
			'}';
		}
	}
}

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
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.RateSourcePage.RateSourcePageBuilder;
import fpml.confirmation.RateSourcePage.RateSourcePageBuilderImpl;
import fpml.confirmation.RateSourcePage.RateSourcePageImpl;
import fpml.confirmation.meta.RateSourcePageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RateSourcePage", builder=RateSourcePage.RateSourcePageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RateSourcePage extends RosettaModelObject {

	RateSourcePageMeta metaData = new RateSourcePageMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRateSourcePageScheme();

	/*********************** Build Methods  ***********************/
	RateSourcePage build();
	
	RateSourcePage.RateSourcePageBuilder toBuilder();
	
	static RateSourcePage.RateSourcePageBuilder builder() {
		return new RateSourcePage.RateSourcePageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateSourcePage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RateSourcePage> getType() {
		return RateSourcePage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("rateSourcePageScheme"), String.class, getRateSourcePageScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateSourcePageBuilder extends RateSourcePage, RosettaModelObjectBuilder {
		RateSourcePage.RateSourcePageBuilder setValue(String value);
		RateSourcePage.RateSourcePageBuilder setRateSourcePageScheme(String rateSourcePageScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("rateSourcePageScheme"), String.class, getRateSourcePageScheme(), this);
		}
		

		RateSourcePage.RateSourcePageBuilder prune();
	}

	/*********************** Immutable Implementation of RateSourcePage  ***********************/
	class RateSourcePageImpl implements RateSourcePage {
		private final String value;
		private final String rateSourcePageScheme;
		
		protected RateSourcePageImpl(RateSourcePage.RateSourcePageBuilder builder) {
			this.value = builder.getValue();
			this.rateSourcePageScheme = builder.getRateSourcePageScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageScheme")
		public String getRateSourcePageScheme() {
			return rateSourcePageScheme;
		}
		
		@Override
		public RateSourcePage build() {
			return this;
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder toBuilder() {
			RateSourcePage.RateSourcePageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateSourcePage.RateSourcePageBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRateSourcePageScheme()).ifPresent(builder::setRateSourcePageScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSourcePage _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(rateSourcePageScheme, _that.getRateSourcePageScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageScheme != null ? rateSourcePageScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateSourcePage {" +
				"value=" + this.value + ", " +
				"rateSourcePageScheme=" + this.rateSourcePageScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RateSourcePage  ***********************/
	class RateSourcePageBuilderImpl implements RateSourcePage.RateSourcePageBuilder {
	
		protected String value;
		protected String rateSourcePageScheme;
	
		public RateSourcePageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageScheme")
		public String getRateSourcePageScheme() {
			return rateSourcePageScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RateSourcePage.RateSourcePageBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePageScheme")
		public RateSourcePage.RateSourcePageBuilder setRateSourcePageScheme(String rateSourcePageScheme) {
			this.rateSourcePageScheme = rateSourcePageScheme==null?null:rateSourcePageScheme;
			return this;
		}
		
		@Override
		public RateSourcePage build() {
			return new RateSourcePage.RateSourcePageImpl(this);
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSourcePage.RateSourcePageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRateSourcePageScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSourcePage.RateSourcePageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateSourcePage.RateSourcePageBuilder o = (RateSourcePage.RateSourcePageBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRateSourcePageScheme(), o.getRateSourcePageScheme(), this::setRateSourcePageScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSourcePage _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(rateSourcePageScheme, _that.getRateSourcePageScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageScheme != null ? rateSourcePageScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateSourcePageBuilder {" +
				"value=" + this.value + ", " +
				"rateSourcePageScheme=" + this.rateSourcePageScheme +
			'}';
		}
	}
}

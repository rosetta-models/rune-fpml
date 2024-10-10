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
import fpml.confirmation.QuoteTiming;
import fpml.confirmation.QuoteTiming.QuoteTimingBuilder;
import fpml.confirmation.QuoteTiming.QuoteTimingBuilderImpl;
import fpml.confirmation.QuoteTiming.QuoteTimingImpl;
import fpml.confirmation.meta.QuoteTimingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="QuoteTiming", builder=QuoteTiming.QuoteTimingBuilderImpl.class, version="${project.version}")
public interface QuoteTiming extends RosettaModelObject {

	QuoteTimingMeta metaData = new QuoteTimingMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getQuoteTimingScheme();

	/*********************** Build Methods  ***********************/
	QuoteTiming build();
	
	QuoteTiming.QuoteTimingBuilder toBuilder();
	
	static QuoteTiming.QuoteTimingBuilder builder() {
		return new QuoteTiming.QuoteTimingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuoteTiming> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuoteTiming> getType() {
		return QuoteTiming.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("quoteTimingScheme"), String.class, getQuoteTimingScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuoteTimingBuilder extends QuoteTiming, RosettaModelObjectBuilder {
		QuoteTiming.QuoteTimingBuilder setValue(String value);
		QuoteTiming.QuoteTimingBuilder setQuoteTimingScheme(String quoteTimingScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("quoteTimingScheme"), String.class, getQuoteTimingScheme(), this);
		}
		

		QuoteTiming.QuoteTimingBuilder prune();
	}

	/*********************** Immutable Implementation of QuoteTiming  ***********************/
	class QuoteTimingImpl implements QuoteTiming {
		private final String value;
		private final String quoteTimingScheme;
		
		protected QuoteTimingImpl(QuoteTiming.QuoteTimingBuilder builder) {
			this.value = builder.getValue();
			this.quoteTimingScheme = builder.getQuoteTimingScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quoteTimingScheme")
		public String getQuoteTimingScheme() {
			return quoteTimingScheme;
		}
		
		@Override
		public QuoteTiming build() {
			return this;
		}
		
		@Override
		public QuoteTiming.QuoteTimingBuilder toBuilder() {
			QuoteTiming.QuoteTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuoteTiming.QuoteTimingBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuoteTimingScheme()).ifPresent(builder::setQuoteTimingScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuoteTiming _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quoteTimingScheme, _that.getQuoteTimingScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quoteTimingScheme != null ? quoteTimingScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuoteTiming {" +
				"value=" + this.value + ", " +
				"quoteTimingScheme=" + this.quoteTimingScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of QuoteTiming  ***********************/
	class QuoteTimingBuilderImpl implements QuoteTiming.QuoteTimingBuilder {
	
		protected String value;
		protected String quoteTimingScheme;
	
		public QuoteTimingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quoteTimingScheme")
		public String getQuoteTimingScheme() {
			return quoteTimingScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public QuoteTiming.QuoteTimingBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("quoteTimingScheme")
		public QuoteTiming.QuoteTimingBuilder setQuoteTimingScheme(String quoteTimingScheme) {
			this.quoteTimingScheme = quoteTimingScheme==null?null:quoteTimingScheme;
			return this;
		}
		
		@Override
		public QuoteTiming build() {
			return new QuoteTiming.QuoteTimingImpl(this);
		}
		
		@Override
		public QuoteTiming.QuoteTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuoteTiming.QuoteTimingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuoteTimingScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuoteTiming.QuoteTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuoteTiming.QuoteTimingBuilder o = (QuoteTiming.QuoteTimingBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQuoteTimingScheme(), o.getQuoteTimingScheme(), this::setQuoteTimingScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuoteTiming _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quoteTimingScheme, _that.getQuoteTimingScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quoteTimingScheme != null ? quoteTimingScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuoteTimingBuilder {" +
				"value=" + this.value + ", " +
				"quoteTimingScheme=" + this.quoteTimingScheme +
			'}';
		}
	}
}

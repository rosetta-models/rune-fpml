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
import fpml.confirmation.PricingContext;
import fpml.confirmation.PricingContext.PricingContextBuilder;
import fpml.confirmation.PricingContext.PricingContextBuilderImpl;
import fpml.confirmation.PricingContext.PricingContextImpl;
import fpml.confirmation.meta.PricingContextMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The reason a trade&#39;s price does not reflect the current market price.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingContext", builder=PricingContext.PricingContextBuilderImpl.class, version="${project.version}")
public interface PricingContext extends RosettaModelObject {

	PricingContextMeta metaData = new PricingContextMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPricingContextScheme();

	/*********************** Build Methods  ***********************/
	PricingContext build();
	
	PricingContext.PricingContextBuilder toBuilder();
	
	static PricingContext.PricingContextBuilder builder() {
		return new PricingContext.PricingContextBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingContext> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingContext> getType() {
		return PricingContext.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("pricingContextScheme"), String.class, getPricingContextScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingContextBuilder extends PricingContext, RosettaModelObjectBuilder {
		PricingContext.PricingContextBuilder setValue(String value);
		PricingContext.PricingContextBuilder setPricingContextScheme(String pricingContextScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("pricingContextScheme"), String.class, getPricingContextScheme(), this);
		}
		

		PricingContext.PricingContextBuilder prune();
	}

	/*********************** Immutable Implementation of PricingContext  ***********************/
	class PricingContextImpl implements PricingContext {
		private final String value;
		private final String pricingContextScheme;
		
		protected PricingContextImpl(PricingContext.PricingContextBuilder builder) {
			this.value = builder.getValue();
			this.pricingContextScheme = builder.getPricingContextScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pricingContextScheme")
		public String getPricingContextScheme() {
			return pricingContextScheme;
		}
		
		@Override
		public PricingContext build() {
			return this;
		}
		
		@Override
		public PricingContext.PricingContextBuilder toBuilder() {
			PricingContext.PricingContextBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingContext.PricingContextBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPricingContextScheme()).ifPresent(builder::setPricingContextScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingContext _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingContextScheme, _that.getPricingContextScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingContextScheme != null ? pricingContextScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingContext {" +
				"value=" + this.value + ", " +
				"pricingContextScheme=" + this.pricingContextScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingContext  ***********************/
	class PricingContextBuilderImpl implements PricingContext.PricingContextBuilder {
	
		protected String value;
		protected String pricingContextScheme;
	
		public PricingContextBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pricingContextScheme")
		public String getPricingContextScheme() {
			return pricingContextScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PricingContext.PricingContextBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("pricingContextScheme")
		public PricingContext.PricingContextBuilder setPricingContextScheme(String pricingContextScheme) {
			this.pricingContextScheme = pricingContextScheme==null?null:pricingContextScheme;
			return this;
		}
		
		@Override
		public PricingContext build() {
			return new PricingContext.PricingContextImpl(this);
		}
		
		@Override
		public PricingContext.PricingContextBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingContext.PricingContextBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPricingContextScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingContext.PricingContextBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingContext.PricingContextBuilder o = (PricingContext.PricingContextBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPricingContextScheme(), o.getPricingContextScheme(), this::setPricingContextScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingContext _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pricingContextScheme, _that.getPricingContextScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pricingContextScheme != null ? pricingContextScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingContextBuilder {" +
				"value=" + this.value + ", " +
				"pricingContextScheme=" + this.pricingContextScheme +
			'}';
		}
	}
}

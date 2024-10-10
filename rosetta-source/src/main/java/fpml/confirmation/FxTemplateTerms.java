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
import fpml.confirmation.FxTemplateTerms;
import fpml.confirmation.FxTemplateTerms.FxTemplateTermsBuilder;
import fpml.confirmation.FxTemplateTerms.FxTemplateTermsBuilderImpl;
import fpml.confirmation.FxTemplateTerms.FxTemplateTermsImpl;
import fpml.confirmation.meta.FxTemplateTermsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference a code defining the origin of the trade template terms
 * @version ${project.version}
 */
@RosettaDataType(value="FxTemplateTerms", builder=FxTemplateTerms.FxTemplateTermsBuilderImpl.class, version="${project.version}")
public interface FxTemplateTerms extends RosettaModelObject {

	FxTemplateTermsMeta metaData = new FxTemplateTermsMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFxTemplateTermsScheme();

	/*********************** Build Methods  ***********************/
	FxTemplateTerms build();
	
	FxTemplateTerms.FxTemplateTermsBuilder toBuilder();
	
	static FxTemplateTerms.FxTemplateTermsBuilder builder() {
		return new FxTemplateTerms.FxTemplateTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTemplateTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTemplateTerms> getType() {
		return FxTemplateTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("fxTemplateTermsScheme"), String.class, getFxTemplateTermsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTemplateTermsBuilder extends FxTemplateTerms, RosettaModelObjectBuilder {
		FxTemplateTerms.FxTemplateTermsBuilder setValue(String value);
		FxTemplateTerms.FxTemplateTermsBuilder setFxTemplateTermsScheme(String fxTemplateTermsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("fxTemplateTermsScheme"), String.class, getFxTemplateTermsScheme(), this);
		}
		

		FxTemplateTerms.FxTemplateTermsBuilder prune();
	}

	/*********************** Immutable Implementation of FxTemplateTerms  ***********************/
	class FxTemplateTermsImpl implements FxTemplateTerms {
		private final String value;
		private final String fxTemplateTermsScheme;
		
		protected FxTemplateTermsImpl(FxTemplateTerms.FxTemplateTermsBuilder builder) {
			this.value = builder.getValue();
			this.fxTemplateTermsScheme = builder.getFxTemplateTermsScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("fxTemplateTermsScheme")
		public String getFxTemplateTermsScheme() {
			return fxTemplateTermsScheme;
		}
		
		@Override
		public FxTemplateTerms build() {
			return this;
		}
		
		@Override
		public FxTemplateTerms.FxTemplateTermsBuilder toBuilder() {
			FxTemplateTerms.FxTemplateTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTemplateTerms.FxTemplateTermsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFxTemplateTermsScheme()).ifPresent(builder::setFxTemplateTermsScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTemplateTerms _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(fxTemplateTermsScheme, _that.getFxTemplateTermsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (fxTemplateTermsScheme != null ? fxTemplateTermsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTemplateTerms {" +
				"value=" + this.value + ", " +
				"fxTemplateTermsScheme=" + this.fxTemplateTermsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTemplateTerms  ***********************/
	class FxTemplateTermsBuilderImpl implements FxTemplateTerms.FxTemplateTermsBuilder {
	
		protected String value;
		protected String fxTemplateTermsScheme;
	
		public FxTemplateTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("fxTemplateTermsScheme")
		public String getFxTemplateTermsScheme() {
			return fxTemplateTermsScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FxTemplateTerms.FxTemplateTermsBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("fxTemplateTermsScheme")
		public FxTemplateTerms.FxTemplateTermsBuilder setFxTemplateTermsScheme(String fxTemplateTermsScheme) {
			this.fxTemplateTermsScheme = fxTemplateTermsScheme==null?null:fxTemplateTermsScheme;
			return this;
		}
		
		@Override
		public FxTemplateTerms build() {
			return new FxTemplateTerms.FxTemplateTermsImpl(this);
		}
		
		@Override
		public FxTemplateTerms.FxTemplateTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTemplateTerms.FxTemplateTermsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFxTemplateTermsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTemplateTerms.FxTemplateTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTemplateTerms.FxTemplateTermsBuilder o = (FxTemplateTerms.FxTemplateTermsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFxTemplateTermsScheme(), o.getFxTemplateTermsScheme(), this::setFxTemplateTermsScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTemplateTerms _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(fxTemplateTermsScheme, _that.getFxTemplateTermsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (fxTemplateTermsScheme != null ? fxTemplateTermsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTemplateTermsBuilder {" +
				"value=" + this.value + ", " +
				"fxTemplateTermsScheme=" + this.fxTemplateTermsScheme +
			'}';
		}
	}
}

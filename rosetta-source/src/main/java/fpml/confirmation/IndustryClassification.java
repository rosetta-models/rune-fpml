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
import fpml.confirmation.IndustryClassification;
import fpml.confirmation.IndustryClassification.IndustryClassificationBuilder;
import fpml.confirmation.IndustryClassification.IndustryClassificationBuilderImpl;
import fpml.confirmation.IndustryClassification.IndustryClassificationImpl;
import fpml.confirmation.meta.IndustryClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A party&#39;s industry sector classification.
 * @version ${project.version}
 */
@RosettaDataType(value="IndustryClassification", builder=IndustryClassification.IndustryClassificationBuilderImpl.class, version="${project.version}")
public interface IndustryClassification extends RosettaModelObject {

	IndustryClassificationMeta metaData = new IndustryClassificationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getIndustryClassificationScheme();

	/*********************** Build Methods  ***********************/
	IndustryClassification build();
	
	IndustryClassification.IndustryClassificationBuilder toBuilder();
	
	static IndustryClassification.IndustryClassificationBuilder builder() {
		return new IndustryClassification.IndustryClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndustryClassification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndustryClassification> getType() {
		return IndustryClassification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("industryClassificationScheme"), String.class, getIndustryClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndustryClassificationBuilder extends IndustryClassification, RosettaModelObjectBuilder {
		IndustryClassification.IndustryClassificationBuilder setValue(String value);
		IndustryClassification.IndustryClassificationBuilder setIndustryClassificationScheme(String industryClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("industryClassificationScheme"), String.class, getIndustryClassificationScheme(), this);
		}
		

		IndustryClassification.IndustryClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of IndustryClassification  ***********************/
	class IndustryClassificationImpl implements IndustryClassification {
		private final String value;
		private final String industryClassificationScheme;
		
		protected IndustryClassificationImpl(IndustryClassification.IndustryClassificationBuilder builder) {
			this.value = builder.getValue();
			this.industryClassificationScheme = builder.getIndustryClassificationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("industryClassificationScheme")
		public String getIndustryClassificationScheme() {
			return industryClassificationScheme;
		}
		
		@Override
		public IndustryClassification build() {
			return this;
		}
		
		@Override
		public IndustryClassification.IndustryClassificationBuilder toBuilder() {
			IndustryClassification.IndustryClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndustryClassification.IndustryClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndustryClassificationScheme()).ifPresent(builder::setIndustryClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustryClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(industryClassificationScheme, _that.getIndustryClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (industryClassificationScheme != null ? industryClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustryClassification {" +
				"value=" + this.value + ", " +
				"industryClassificationScheme=" + this.industryClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndustryClassification  ***********************/
	class IndustryClassificationBuilderImpl implements IndustryClassification.IndustryClassificationBuilder {
	
		protected String value;
		protected String industryClassificationScheme;
	
		public IndustryClassificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("industryClassificationScheme")
		public String getIndustryClassificationScheme() {
			return industryClassificationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public IndustryClassification.IndustryClassificationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("industryClassificationScheme")
		public IndustryClassification.IndustryClassificationBuilder setIndustryClassificationScheme(String industryClassificationScheme) {
			this.industryClassificationScheme = industryClassificationScheme==null?null:industryClassificationScheme;
			return this;
		}
		
		@Override
		public IndustryClassification build() {
			return new IndustryClassification.IndustryClassificationImpl(this);
		}
		
		@Override
		public IndustryClassification.IndustryClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustryClassification.IndustryClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndustryClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustryClassification.IndustryClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndustryClassification.IndustryClassificationBuilder o = (IndustryClassification.IndustryClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndustryClassificationScheme(), o.getIndustryClassificationScheme(), this::setIndustryClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustryClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(industryClassificationScheme, _that.getIndustryClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (industryClassificationScheme != null ? industryClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustryClassificationBuilder {" +
				"value=" + this.value + ", " +
				"industryClassificationScheme=" + this.industryClassificationScheme +
			'}';
		}
	}
}

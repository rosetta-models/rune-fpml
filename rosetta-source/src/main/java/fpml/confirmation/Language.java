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
import fpml.confirmation.Language;
import fpml.confirmation.Language.LanguageBuilder;
import fpml.confirmation.Language.LanguageBuilderImpl;
import fpml.confirmation.Language.LanguageImpl;
import fpml.confirmation.meta.LanguageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for indicating the language of the resource, described using the ISO 639-2/T Code.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Language", builder=Language.LanguageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Language extends RosettaModelObject {

	LanguageMeta metaData = new LanguageMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLanguageScheme();

	/*********************** Build Methods  ***********************/
	Language build();
	
	Language.LanguageBuilder toBuilder();
	
	static Language.LanguageBuilder builder() {
		return new Language.LanguageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Language> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Language> getType() {
		return Language.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("languageScheme"), String.class, getLanguageScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LanguageBuilder extends Language, RosettaModelObjectBuilder {
		Language.LanguageBuilder setValue(String value);
		Language.LanguageBuilder setLanguageScheme(String languageScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("languageScheme"), String.class, getLanguageScheme(), this);
		}
		

		Language.LanguageBuilder prune();
	}

	/*********************** Immutable Implementation of Language  ***********************/
	class LanguageImpl implements Language {
		private final String value;
		private final String languageScheme;
		
		protected LanguageImpl(Language.LanguageBuilder builder) {
			this.value = builder.getValue();
			this.languageScheme = builder.getLanguageScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("languageScheme")
		public String getLanguageScheme() {
			return languageScheme;
		}
		
		@Override
		public Language build() {
			return this;
		}
		
		@Override
		public Language.LanguageBuilder toBuilder() {
			Language.LanguageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Language.LanguageBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLanguageScheme()).ifPresent(builder::setLanguageScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Language _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(languageScheme, _that.getLanguageScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (languageScheme != null ? languageScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Language {" +
				"value=" + this.value + ", " +
				"languageScheme=" + this.languageScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Language  ***********************/
	class LanguageBuilderImpl implements Language.LanguageBuilder {
	
		protected String value;
		protected String languageScheme;
	
		public LanguageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("languageScheme")
		public String getLanguageScheme() {
			return languageScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Language.LanguageBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("languageScheme")
		public Language.LanguageBuilder setLanguageScheme(String languageScheme) {
			this.languageScheme = languageScheme==null?null:languageScheme;
			return this;
		}
		
		@Override
		public Language build() {
			return new Language.LanguageImpl(this);
		}
		
		@Override
		public Language.LanguageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Language.LanguageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLanguageScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Language.LanguageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Language.LanguageBuilder o = (Language.LanguageBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLanguageScheme(), o.getLanguageScheme(), this::setLanguageScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Language _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(languageScheme, _that.getLanguageScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (languageScheme != null ? languageScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LanguageBuilder {" +
				"value=" + this.value + ", " +
				"languageScheme=" + this.languageScheme +
			'}';
		}
	}
}

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
import fpml.confirmation.GenericExerciseStyle;
import fpml.confirmation.GenericExerciseStyle.GenericExerciseStyleBuilder;
import fpml.confirmation.GenericExerciseStyle.GenericExerciseStyleBuilderImpl;
import fpml.confirmation.GenericExerciseStyle.GenericExerciseStyleImpl;
import fpml.confirmation.meta.GenericExerciseStyleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used to hold the exercise style description of an option in a generic product (e.g. American, European, Bermudan).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GenericExerciseStyle", builder=GenericExerciseStyle.GenericExerciseStyleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GenericExerciseStyle extends RosettaModelObject {

	GenericExerciseStyleMeta metaData = new GenericExerciseStyleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The value scheme used with this property.
	 */
	String getExerciseStyleScheme();

	/*********************** Build Methods  ***********************/
	GenericExerciseStyle build();
	
	GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder();
	
	static GenericExerciseStyle.GenericExerciseStyleBuilder builder() {
		return new GenericExerciseStyle.GenericExerciseStyleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericExerciseStyle> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericExerciseStyle> getType() {
		return GenericExerciseStyle.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("exerciseStyleScheme"), String.class, getExerciseStyleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericExerciseStyleBuilder extends GenericExerciseStyle, RosettaModelObjectBuilder {
		GenericExerciseStyle.GenericExerciseStyleBuilder setValue(String value);
		GenericExerciseStyle.GenericExerciseStyleBuilder setExerciseStyleScheme(String exerciseStyleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("exerciseStyleScheme"), String.class, getExerciseStyleScheme(), this);
		}
		

		GenericExerciseStyle.GenericExerciseStyleBuilder prune();
	}

	/*********************** Immutable Implementation of GenericExerciseStyle  ***********************/
	class GenericExerciseStyleImpl implements GenericExerciseStyle {
		private final String value;
		private final String exerciseStyleScheme;
		
		protected GenericExerciseStyleImpl(GenericExerciseStyle.GenericExerciseStyleBuilder builder) {
			this.value = builder.getValue();
			this.exerciseStyleScheme = builder.getExerciseStyleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("exerciseStyleScheme")
		public String getExerciseStyleScheme() {
			return exerciseStyleScheme;
		}
		
		@Override
		public GenericExerciseStyle build() {
			return this;
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder() {
			GenericExerciseStyle.GenericExerciseStyleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericExerciseStyle.GenericExerciseStyleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExerciseStyleScheme()).ifPresent(builder::setExerciseStyleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericExerciseStyle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exerciseStyleScheme, _that.getExerciseStyleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exerciseStyleScheme != null ? exerciseStyleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericExerciseStyle {" +
				"value=" + this.value + ", " +
				"exerciseStyleScheme=" + this.exerciseStyleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericExerciseStyle  ***********************/
	class GenericExerciseStyleBuilderImpl implements GenericExerciseStyle.GenericExerciseStyleBuilder {
	
		protected String value;
		protected String exerciseStyleScheme;
	
		public GenericExerciseStyleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("exerciseStyleScheme")
		public String getExerciseStyleScheme() {
			return exerciseStyleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public GenericExerciseStyle.GenericExerciseStyleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseStyleScheme")
		public GenericExerciseStyle.GenericExerciseStyleBuilder setExerciseStyleScheme(String exerciseStyleScheme) {
			this.exerciseStyleScheme = exerciseStyleScheme==null?null:exerciseStyleScheme;
			return this;
		}
		
		@Override
		public GenericExerciseStyle build() {
			return new GenericExerciseStyle.GenericExerciseStyleImpl(this);
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExerciseStyleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericExerciseStyle.GenericExerciseStyleBuilder o = (GenericExerciseStyle.GenericExerciseStyleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExerciseStyleScheme(), o.getExerciseStyleScheme(), this::setExerciseStyleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericExerciseStyle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exerciseStyleScheme, _that.getExerciseStyleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exerciseStyleScheme != null ? exerciseStyleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericExerciseStyleBuilder {" +
				"value=" + this.value + ", " +
				"exerciseStyleScheme=" + this.exerciseStyleScheme +
			'}';
		}
	}
}

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
import fpml.confirmation.CompoundingFrequency;
import fpml.confirmation.CompoundingFrequency.CompoundingFrequencyBuilder;
import fpml.confirmation.CompoundingFrequency.CompoundingFrequencyBuilderImpl;
import fpml.confirmation.CompoundingFrequency.CompoundingFrequencyImpl;
import fpml.confirmation.meta.CompoundingFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CompoundingFrequency", builder=CompoundingFrequency.CompoundingFrequencyBuilderImpl.class, version="${project.version}")
public interface CompoundingFrequency extends RosettaModelObject {

	CompoundingFrequencyMeta metaData = new CompoundingFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCompoundingFrequencyScheme();

	/*********************** Build Methods  ***********************/
	CompoundingFrequency build();
	
	CompoundingFrequency.CompoundingFrequencyBuilder toBuilder();
	
	static CompoundingFrequency.CompoundingFrequencyBuilder builder() {
		return new CompoundingFrequency.CompoundingFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompoundingFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompoundingFrequency> getType() {
		return CompoundingFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("compoundingFrequencyScheme"), String.class, getCompoundingFrequencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompoundingFrequencyBuilder extends CompoundingFrequency, RosettaModelObjectBuilder {
		CompoundingFrequency.CompoundingFrequencyBuilder setValue(String value);
		CompoundingFrequency.CompoundingFrequencyBuilder setCompoundingFrequencyScheme(String compoundingFrequencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("compoundingFrequencyScheme"), String.class, getCompoundingFrequencyScheme(), this);
		}
		

		CompoundingFrequency.CompoundingFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of CompoundingFrequency  ***********************/
	class CompoundingFrequencyImpl implements CompoundingFrequency {
		private final String value;
		private final String compoundingFrequencyScheme;
		
		protected CompoundingFrequencyImpl(CompoundingFrequency.CompoundingFrequencyBuilder builder) {
			this.value = builder.getValue();
			this.compoundingFrequencyScheme = builder.getCompoundingFrequencyScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compoundingFrequencyScheme")
		public String getCompoundingFrequencyScheme() {
			return compoundingFrequencyScheme;
		}
		
		@Override
		public CompoundingFrequency build() {
			return this;
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder toBuilder() {
			CompoundingFrequency.CompoundingFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompoundingFrequency.CompoundingFrequencyBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCompoundingFrequencyScheme()).ifPresent(builder::setCompoundingFrequencyScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compoundingFrequencyScheme, _that.getCompoundingFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compoundingFrequencyScheme != null ? compoundingFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingFrequency {" +
				"value=" + this.value + ", " +
				"compoundingFrequencyScheme=" + this.compoundingFrequencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CompoundingFrequency  ***********************/
	class CompoundingFrequencyBuilderImpl implements CompoundingFrequency.CompoundingFrequencyBuilder {
	
		protected String value;
		protected String compoundingFrequencyScheme;
	
		public CompoundingFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("compoundingFrequencyScheme")
		public String getCompoundingFrequencyScheme() {
			return compoundingFrequencyScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CompoundingFrequency.CompoundingFrequencyBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("compoundingFrequencyScheme")
		public CompoundingFrequency.CompoundingFrequencyBuilder setCompoundingFrequencyScheme(String compoundingFrequencyScheme) {
			this.compoundingFrequencyScheme = compoundingFrequencyScheme==null?null:compoundingFrequencyScheme;
			return this;
		}
		
		@Override
		public CompoundingFrequency build() {
			return new CompoundingFrequency.CompoundingFrequencyImpl(this);
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCompoundingFrequencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompoundingFrequency.CompoundingFrequencyBuilder o = (CompoundingFrequency.CompoundingFrequencyBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCompoundingFrequencyScheme(), o.getCompoundingFrequencyScheme(), this::setCompoundingFrequencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingFrequency _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(compoundingFrequencyScheme, _that.getCompoundingFrequencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (compoundingFrequencyScheme != null ? compoundingFrequencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingFrequencyBuilder {" +
				"value=" + this.value + ", " +
				"compoundingFrequencyScheme=" + this.compoundingFrequencyScheme +
			'}';
		}
	}
}

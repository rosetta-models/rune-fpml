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
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.FloatingRateIndex.FloatingRateIndexBuilder;
import fpml.confirmation.FloatingRateIndex.FloatingRateIndexBuilderImpl;
import fpml.confirmation.FloatingRateIndex.FloatingRateIndexImpl;
import fpml.confirmation.meta.FloatingRateIndexMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The ISDA Floating Rate Option, i.e. the floating rate index.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateIndex", builder=FloatingRateIndex.FloatingRateIndexBuilderImpl.class, version="${project.version}")
public interface FloatingRateIndex extends RosettaModelObject {

	FloatingRateIndexMeta metaData = new FloatingRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFloatingRateIndexScheme();

	/*********************** Build Methods  ***********************/
	FloatingRateIndex build();
	
	FloatingRateIndex.FloatingRateIndexBuilder toBuilder();
	
	static FloatingRateIndex.FloatingRateIndexBuilder builder() {
		return new FloatingRateIndex.FloatingRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateIndex> getType() {
		return FloatingRateIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("floatingRateIndexScheme"), String.class, getFloatingRateIndexScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexBuilder extends FloatingRateIndex, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder setValue(String value);
		FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndexScheme(String floatingRateIndexScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("floatingRateIndexScheme"), String.class, getFloatingRateIndexScheme(), this);
		}
		

		FloatingRateIndex.FloatingRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexImpl implements FloatingRateIndex {
		private final String value;
		private final String floatingRateIndexScheme;
		
		protected FloatingRateIndexImpl(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			this.value = builder.getValue();
			this.floatingRateIndexScheme = builder.getFloatingRateIndexScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public String getFloatingRateIndexScheme() {
			return floatingRateIndexScheme;
		}
		
		@Override
		public FloatingRateIndex build() {
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			FloatingRateIndex.FloatingRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFloatingRateIndexScheme()).ifPresent(builder::setFloatingRateIndexScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(floatingRateIndexScheme, _that.getFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndexScheme != null ? floatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndex {" +
				"value=" + this.value + ", " +
				"floatingRateIndexScheme=" + this.floatingRateIndexScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexBuilderImpl implements FloatingRateIndex.FloatingRateIndexBuilder {
	
		protected String value;
		protected String floatingRateIndexScheme;
	
		public FloatingRateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public String getFloatingRateIndexScheme() {
			return floatingRateIndexScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndex.FloatingRateIndexBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexScheme")
		public FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndexScheme(String floatingRateIndexScheme) {
			this.floatingRateIndexScheme = floatingRateIndexScheme==null?null:floatingRateIndexScheme;
			return this;
		}
		
		@Override
		public FloatingRateIndex build() {
			return new FloatingRateIndex.FloatingRateIndexImpl(this);
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFloatingRateIndexScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndex.FloatingRateIndexBuilder o = (FloatingRateIndex.FloatingRateIndexBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFloatingRateIndexScheme(), o.getFloatingRateIndexScheme(), this::setFloatingRateIndexScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(floatingRateIndexScheme, _that.getFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndexScheme != null ? floatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexBuilder {" +
				"value=" + this.value + ", " +
				"floatingRateIndexScheme=" + this.floatingRateIndexScheme +
			'}';
		}
	}
}

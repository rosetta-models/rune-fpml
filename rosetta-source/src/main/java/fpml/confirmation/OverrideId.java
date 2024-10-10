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
import fpml.confirmation.OverrideId;
import fpml.confirmation.OverrideId.OverrideIdBuilder;
import fpml.confirmation.OverrideId.OverrideIdBuilderImpl;
import fpml.confirmation.OverrideId.OverrideIdImpl;
import fpml.confirmation.meta.OverrideIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines an override identifier based on a qualifying scheme.
 * @version ${project.version}
 */
@RosettaDataType(value="OverrideId", builder=OverrideId.OverrideIdBuilderImpl.class, version="${project.version}")
public interface OverrideId extends RosettaModelObject {

	OverrideIdMeta metaData = new OverrideIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getOverrideIdScheme();

	/*********************** Build Methods  ***********************/
	OverrideId build();
	
	OverrideId.OverrideIdBuilder toBuilder();
	
	static OverrideId.OverrideIdBuilder builder() {
		return new OverrideId.OverrideIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OverrideId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OverrideId> getType() {
		return OverrideId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("overrideIdScheme"), String.class, getOverrideIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OverrideIdBuilder extends OverrideId, RosettaModelObjectBuilder {
		OverrideId.OverrideIdBuilder setValue(String value);
		OverrideId.OverrideIdBuilder setOverrideIdScheme(String overrideIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("overrideIdScheme"), String.class, getOverrideIdScheme(), this);
		}
		

		OverrideId.OverrideIdBuilder prune();
	}

	/*********************** Immutable Implementation of OverrideId  ***********************/
	class OverrideIdImpl implements OverrideId {
		private final String value;
		private final String overrideIdScheme;
		
		protected OverrideIdImpl(OverrideId.OverrideIdBuilder builder) {
			this.value = builder.getValue();
			this.overrideIdScheme = builder.getOverrideIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("overrideIdScheme")
		public String getOverrideIdScheme() {
			return overrideIdScheme;
		}
		
		@Override
		public OverrideId build() {
			return this;
		}
		
		@Override
		public OverrideId.OverrideIdBuilder toBuilder() {
			OverrideId.OverrideIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OverrideId.OverrideIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOverrideIdScheme()).ifPresent(builder::setOverrideIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OverrideId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(overrideIdScheme, _that.getOverrideIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (overrideIdScheme != null ? overrideIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OverrideId {" +
				"value=" + this.value + ", " +
				"overrideIdScheme=" + this.overrideIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OverrideId  ***********************/
	class OverrideIdBuilderImpl implements OverrideId.OverrideIdBuilder {
	
		protected String value;
		protected String overrideIdScheme;
	
		public OverrideIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("overrideIdScheme")
		public String getOverrideIdScheme() {
			return overrideIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public OverrideId.OverrideIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("overrideIdScheme")
		public OverrideId.OverrideIdBuilder setOverrideIdScheme(String overrideIdScheme) {
			this.overrideIdScheme = overrideIdScheme==null?null:overrideIdScheme;
			return this;
		}
		
		@Override
		public OverrideId build() {
			return new OverrideId.OverrideIdImpl(this);
		}
		
		@Override
		public OverrideId.OverrideIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OverrideId.OverrideIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOverrideIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OverrideId.OverrideIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OverrideId.OverrideIdBuilder o = (OverrideId.OverrideIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOverrideIdScheme(), o.getOverrideIdScheme(), this::setOverrideIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OverrideId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(overrideIdScheme, _that.getOverrideIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (overrideIdScheme != null ? overrideIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OverrideIdBuilder {" +
				"value=" + this.value + ", " +
				"overrideIdScheme=" + this.overrideIdScheme +
			'}';
		}
	}
}

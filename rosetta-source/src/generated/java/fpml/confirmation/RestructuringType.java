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
import fpml.confirmation.RestructuringType;
import fpml.confirmation.RestructuringType.RestructuringTypeBuilder;
import fpml.confirmation.RestructuringType.RestructuringTypeBuilderImpl;
import fpml.confirmation.RestructuringType.RestructuringTypeImpl;
import fpml.confirmation.meta.RestructuringTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RestructuringType", builder=RestructuringType.RestructuringTypeBuilderImpl.class, version="${project.version}")
public interface RestructuringType extends RosettaModelObject {

	RestructuringTypeMeta metaData = new RestructuringTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRestructuringScheme();

	/*********************** Build Methods  ***********************/
	RestructuringType build();
	
	RestructuringType.RestructuringTypeBuilder toBuilder();
	
	static RestructuringType.RestructuringTypeBuilder builder() {
		return new RestructuringType.RestructuringTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RestructuringType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RestructuringType> getType() {
		return RestructuringType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("restructuringScheme"), String.class, getRestructuringScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringTypeBuilder extends RestructuringType, RosettaModelObjectBuilder {
		RestructuringType.RestructuringTypeBuilder setValue(String value);
		RestructuringType.RestructuringTypeBuilder setRestructuringScheme(String restructuringScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("restructuringScheme"), String.class, getRestructuringScheme(), this);
		}
		

		RestructuringType.RestructuringTypeBuilder prune();
	}

	/*********************** Immutable Implementation of RestructuringType  ***********************/
	class RestructuringTypeImpl implements RestructuringType {
		private final String value;
		private final String restructuringScheme;
		
		protected RestructuringTypeImpl(RestructuringType.RestructuringTypeBuilder builder) {
			this.value = builder.getValue();
			this.restructuringScheme = builder.getRestructuringScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("restructuringScheme")
		public String getRestructuringScheme() {
			return restructuringScheme;
		}
		
		@Override
		public RestructuringType build() {
			return this;
		}
		
		@Override
		public RestructuringType.RestructuringTypeBuilder toBuilder() {
			RestructuringType.RestructuringTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RestructuringType.RestructuringTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRestructuringScheme()).ifPresent(builder::setRestructuringScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RestructuringType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(restructuringScheme, _that.getRestructuringScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (restructuringScheme != null ? restructuringScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringType {" +
				"value=" + this.value + ", " +
				"restructuringScheme=" + this.restructuringScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RestructuringType  ***********************/
	class RestructuringTypeBuilderImpl implements RestructuringType.RestructuringTypeBuilder {
	
		protected String value;
		protected String restructuringScheme;
	
		public RestructuringTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("restructuringScheme")
		public String getRestructuringScheme() {
			return restructuringScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RestructuringType.RestructuringTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("restructuringScheme")
		public RestructuringType.RestructuringTypeBuilder setRestructuringScheme(String restructuringScheme) {
			this.restructuringScheme = restructuringScheme==null?null:restructuringScheme;
			return this;
		}
		
		@Override
		public RestructuringType build() {
			return new RestructuringType.RestructuringTypeImpl(this);
		}
		
		@Override
		public RestructuringType.RestructuringTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringType.RestructuringTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRestructuringScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringType.RestructuringTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RestructuringType.RestructuringTypeBuilder o = (RestructuringType.RestructuringTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRestructuringScheme(), o.getRestructuringScheme(), this::setRestructuringScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RestructuringType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(restructuringScheme, _that.getRestructuringScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (restructuringScheme != null ? restructuringScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringTypeBuilder {" +
				"value=" + this.value + ", " +
				"restructuringScheme=" + this.restructuringScheme +
			'}';
		}
	}
}

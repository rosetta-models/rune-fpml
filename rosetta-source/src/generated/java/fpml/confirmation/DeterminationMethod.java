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
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.DeterminationMethod.DeterminationMethodBuilder;
import fpml.confirmation.DeterminationMethod.DeterminationMethodBuilderImpl;
import fpml.confirmation.DeterminationMethod.DeterminationMethodImpl;
import fpml.confirmation.meta.DeterminationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Coding scheme that specifies the method according to which an amount or a date is determined.
 * @version ${project.version}
 */
@RosettaDataType(value="DeterminationMethod", builder=DeterminationMethod.DeterminationMethodBuilderImpl.class, version="${project.version}")
public interface DeterminationMethod extends RosettaModelObject {

	DeterminationMethodMeta metaData = new DeterminationMethodMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeterminationMethodScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	DeterminationMethod build();
	
	DeterminationMethod.DeterminationMethodBuilder toBuilder();
	
	static DeterminationMethod.DeterminationMethodBuilder builder() {
		return new DeterminationMethod.DeterminationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeterminationMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeterminationMethod> getType() {
		return DeterminationMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("determinationMethodScheme"), String.class, getDeterminationMethodScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeterminationMethodBuilder extends DeterminationMethod, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder setValue(String value);
		DeterminationMethod.DeterminationMethodBuilder setDeterminationMethodScheme(String determinationMethodScheme);
		DeterminationMethod.DeterminationMethodBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("determinationMethodScheme"), String.class, getDeterminationMethodScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		DeterminationMethod.DeterminationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DeterminationMethod  ***********************/
	class DeterminationMethodImpl implements DeterminationMethod {
		private final String value;
		private final String determinationMethodScheme;
		private final String id;
		
		protected DeterminationMethodImpl(DeterminationMethod.DeterminationMethodBuilder builder) {
			this.value = builder.getValue();
			this.determinationMethodScheme = builder.getDeterminationMethodScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("determinationMethodScheme")
		public String getDeterminationMethodScheme() {
			return determinationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public DeterminationMethod build() {
			return this;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder toBuilder() {
			DeterminationMethod.DeterminationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeterminationMethod.DeterminationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeterminationMethodScheme()).ifPresent(builder::setDeterminationMethodScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(determinationMethodScheme, _that.getDeterminationMethodScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (determinationMethodScheme != null ? determinationMethodScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethod {" +
				"value=" + this.value + ", " +
				"determinationMethodScheme=" + this.determinationMethodScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DeterminationMethod  ***********************/
	class DeterminationMethodBuilderImpl implements DeterminationMethod.DeterminationMethodBuilder {
	
		protected String value;
		protected String determinationMethodScheme;
		protected String id;
	
		public DeterminationMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("determinationMethodScheme")
		public String getDeterminationMethodScheme() {
			return determinationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public DeterminationMethod.DeterminationMethodBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("determinationMethodScheme")
		public DeterminationMethod.DeterminationMethodBuilder setDeterminationMethodScheme(String determinationMethodScheme) {
			this.determinationMethodScheme = determinationMethodScheme==null?null:determinationMethodScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DeterminationMethod.DeterminationMethodBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public DeterminationMethod build() {
			return new DeterminationMethod.DeterminationMethodImpl(this);
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeterminationMethodScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeterminationMethod.DeterminationMethodBuilder o = (DeterminationMethod.DeterminationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeterminationMethodScheme(), o.getDeterminationMethodScheme(), this::setDeterminationMethodScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(determinationMethodScheme, _that.getDeterminationMethodScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (determinationMethodScheme != null ? determinationMethodScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodBuilder {" +
				"value=" + this.value + ", " +
				"determinationMethodScheme=" + this.determinationMethodScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

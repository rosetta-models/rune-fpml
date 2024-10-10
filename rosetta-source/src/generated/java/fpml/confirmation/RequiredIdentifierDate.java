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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.RequiredIdentifierDate;
import fpml.confirmation.RequiredIdentifierDate.RequiredIdentifierDateBuilder;
import fpml.confirmation.RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl;
import fpml.confirmation.RequiredIdentifierDate.RequiredIdentifierDateImpl;
import fpml.confirmation.meta.RequiredIdentifierDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A date with a required identifier which can be referenced elsewhere.
 * @version ${project.version}
 */
@RosettaDataType(value="RequiredIdentifierDate", builder=RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl.class, version="${project.version}")
public interface RequiredIdentifierDate extends RosettaModelObject {

	RequiredIdentifierDateMeta metaData = new RequiredIdentifierDateMeta();

	/*********************** Getter Methods  ***********************/
	Date getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	RequiredIdentifierDate build();
	
	RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder();
	
	static RequiredIdentifierDate.RequiredIdentifierDateBuilder builder() {
		return new RequiredIdentifierDate.RequiredIdentifierDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequiredIdentifierDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequiredIdentifierDate> getType() {
		return RequiredIdentifierDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequiredIdentifierDateBuilder extends RequiredIdentifierDate, RosettaModelObjectBuilder {
		RequiredIdentifierDate.RequiredIdentifierDateBuilder setValue(Date value);
		RequiredIdentifierDate.RequiredIdentifierDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		RequiredIdentifierDate.RequiredIdentifierDateBuilder prune();
	}

	/*********************** Immutable Implementation of RequiredIdentifierDate  ***********************/
	class RequiredIdentifierDateImpl implements RequiredIdentifierDate {
		private final Date value;
		private final String id;
		
		protected RequiredIdentifierDateImpl(RequiredIdentifierDate.RequiredIdentifierDateBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public Date getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public RequiredIdentifierDate build() {
			return this;
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder() {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequiredIdentifierDate.RequiredIdentifierDateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequiredIdentifierDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequiredIdentifierDate {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of RequiredIdentifierDate  ***********************/
	class RequiredIdentifierDateBuilderImpl implements RequiredIdentifierDate.RequiredIdentifierDateBuilder {
	
		protected Date value;
		protected String id;
	
		public RequiredIdentifierDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public Date getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder setValue(Date value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public RequiredIdentifierDate build() {
			return new RequiredIdentifierDate.RequiredIdentifierDateImpl(this);
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder o = (RequiredIdentifierDate.RequiredIdentifierDateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RequiredIdentifierDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequiredIdentifierDateBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

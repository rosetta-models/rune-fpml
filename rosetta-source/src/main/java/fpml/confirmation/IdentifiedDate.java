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
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.IdentifiedDate.IdentifiedDateBuilder;
import fpml.confirmation.IdentifiedDate.IdentifiedDateBuilderImpl;
import fpml.confirmation.IdentifiedDate.IdentifiedDateImpl;
import fpml.confirmation.meta.IdentifiedDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A date which can be referenced elsewhere.
 * @version ${project.version}
 */
@RosettaDataType(value="IdentifiedDate", builder=IdentifiedDate.IdentifiedDateBuilderImpl.class, version="${project.version}")
public interface IdentifiedDate extends RosettaModelObject {

	IdentifiedDateMeta metaData = new IdentifiedDateMeta();

	/*********************** Getter Methods  ***********************/
	Date getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedDate build();
	
	IdentifiedDate.IdentifiedDateBuilder toBuilder();
	
	static IdentifiedDate.IdentifiedDateBuilder builder() {
		return new IdentifiedDate.IdentifiedDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedDate> getType() {
		return IdentifiedDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedDateBuilder extends IdentifiedDate, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder setValue(Date value);
		IdentifiedDate.IdentifiedDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedDate.IdentifiedDateBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedDate  ***********************/
	class IdentifiedDateImpl implements IdentifiedDate {
		private final Date value;
		private final String id;
		
		protected IdentifiedDateImpl(IdentifiedDate.IdentifiedDateBuilder builder) {
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
		public IdentifiedDate build() {
			return this;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder toBuilder() {
			IdentifiedDate.IdentifiedDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedDate.IdentifiedDateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedDate _that = getType().cast(o);
		
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
			return "IdentifiedDate {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of IdentifiedDate  ***********************/
	class IdentifiedDateBuilderImpl implements IdentifiedDate.IdentifiedDateBuilder {
	
		protected Date value;
		protected String id;
	
		public IdentifiedDateBuilderImpl() {
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
		public IdentifiedDate.IdentifiedDateBuilder setValue(Date value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public IdentifiedDate.IdentifiedDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public IdentifiedDate build() {
			return new IdentifiedDate.IdentifiedDateImpl(this);
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedDate.IdentifiedDateBuilder prune() {
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
		public IdentifiedDate.IdentifiedDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IdentifiedDate.IdentifiedDateBuilder o = (IdentifiedDate.IdentifiedDateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedDate _that = getType().cast(o);
		
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
			return "IdentifiedDateBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

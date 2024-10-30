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
import fpml.confirmation.PersonId;
import fpml.confirmation.PersonId.PersonIdBuilder;
import fpml.confirmation.PersonId.PersonIdBuilderImpl;
import fpml.confirmation.PersonId.PersonIdImpl;
import fpml.confirmation.meta.PersonIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An identifier used to identify an individual person.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PersonId", builder=PersonId.PersonIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PersonId extends RosettaModelObject {

	PersonIdMeta metaData = new PersonIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPersonIdScheme();

	/*********************** Build Methods  ***********************/
	PersonId build();
	
	PersonId.PersonIdBuilder toBuilder();
	
	static PersonId.PersonIdBuilder builder() {
		return new PersonId.PersonIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PersonId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PersonId> getType() {
		return PersonId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("personIdScheme"), String.class, getPersonIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonIdBuilder extends PersonId, RosettaModelObjectBuilder {
		PersonId.PersonIdBuilder setValue(String value);
		PersonId.PersonIdBuilder setPersonIdScheme(String personIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("personIdScheme"), String.class, getPersonIdScheme(), this);
		}
		

		PersonId.PersonIdBuilder prune();
	}

	/*********************** Immutable Implementation of PersonId  ***********************/
	class PersonIdImpl implements PersonId {
		private final String value;
		private final String personIdScheme;
		
		protected PersonIdImpl(PersonId.PersonIdBuilder builder) {
			this.value = builder.getValue();
			this.personIdScheme = builder.getPersonIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("personIdScheme")
		public String getPersonIdScheme() {
			return personIdScheme;
		}
		
		@Override
		public PersonId build() {
			return this;
		}
		
		@Override
		public PersonId.PersonIdBuilder toBuilder() {
			PersonId.PersonIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PersonId.PersonIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPersonIdScheme()).ifPresent(builder::setPersonIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(personIdScheme, _that.getPersonIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (personIdScheme != null ? personIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonId {" +
				"value=" + this.value + ", " +
				"personIdScheme=" + this.personIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PersonId  ***********************/
	class PersonIdBuilderImpl implements PersonId.PersonIdBuilder {
	
		protected String value;
		protected String personIdScheme;
	
		public PersonIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("personIdScheme")
		public String getPersonIdScheme() {
			return personIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PersonId.PersonIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("personIdScheme")
		public PersonId.PersonIdBuilder setPersonIdScheme(String personIdScheme) {
			this.personIdScheme = personIdScheme==null?null:personIdScheme;
			return this;
		}
		
		@Override
		public PersonId build() {
			return new PersonId.PersonIdImpl(this);
		}
		
		@Override
		public PersonId.PersonIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonId.PersonIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPersonIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonId.PersonIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PersonId.PersonIdBuilder o = (PersonId.PersonIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPersonIdScheme(), o.getPersonIdScheme(), this::setPersonIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(personIdScheme, _that.getPersonIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (personIdScheme != null ? personIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonIdBuilder {" +
				"value=" + this.value + ", " +
				"personIdScheme=" + this.personIdScheme +
			'}';
		}
	}
}

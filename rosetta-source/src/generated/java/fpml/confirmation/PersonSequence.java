package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.PersonSequence;
import fpml.confirmation.PersonSequence.PersonSequenceBuilder;
import fpml.confirmation.PersonSequence.PersonSequenceBuilderImpl;
import fpml.confirmation.PersonSequence.PersonSequenceImpl;
import fpml.confirmation.meta.PersonSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PersonSequence", builder=PersonSequence.PersonSequenceBuilderImpl.class, version="${project.version}")
public interface PersonSequence extends RosettaModelObject {

	PersonSequenceMeta metaData = new PersonSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An honorific title, such as Mr., Ms., Dr. etc.
	 */
	String getHonorific();
	/**
	 * Given name, such as John or Mary.
	 */
	String getFirstName();
	List<String> getMiddleName();
	List<String> getInitial();
	/**
	 * Family name, such as Smith or Jones.
	 */
	String getSurname();
	/**
	 * Name suffix, such as Jr., III, etc.
	 */
	String getSuffix();

	/*********************** Build Methods  ***********************/
	PersonSequence build();
	
	PersonSequence.PersonSequenceBuilder toBuilder();
	
	static PersonSequence.PersonSequenceBuilder builder() {
		return new PersonSequence.PersonSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PersonSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PersonSequence> getType() {
		return PersonSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
		processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
		processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
		processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
		processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
		processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonSequenceBuilder extends PersonSequence, RosettaModelObjectBuilder {
		PersonSequence.PersonSequenceBuilder setHonorific(String honorific);
		PersonSequence.PersonSequenceBuilder setFirstName(String firstName);
		PersonSequence.PersonSequenceBuilder addMiddleName(String middleName0);
		PersonSequence.PersonSequenceBuilder addMiddleName(String middleName1, int _idx);
		PersonSequence.PersonSequenceBuilder addMiddleName(List<String> middleName2);
		PersonSequence.PersonSequenceBuilder setMiddleName(List<String> middleName3);
		PersonSequence.PersonSequenceBuilder addInitial(String initial0);
		PersonSequence.PersonSequenceBuilder addInitial(String initial1, int _idx);
		PersonSequence.PersonSequenceBuilder addInitial(List<String> initial2);
		PersonSequence.PersonSequenceBuilder setInitial(List<String> initial3);
		PersonSequence.PersonSequenceBuilder setSurname(String surname);
		PersonSequence.PersonSequenceBuilder setSuffix(String suffix);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
			processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
			processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
			processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
			processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
			processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
		}
		

		PersonSequence.PersonSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of PersonSequence  ***********************/
	class PersonSequenceImpl implements PersonSequence {
		private final String honorific;
		private final String firstName;
		private final List<String> middleName;
		private final List<String> initial;
		private final String surname;
		private final String suffix;
		
		protected PersonSequenceImpl(PersonSequence.PersonSequenceBuilder builder) {
			this.honorific = builder.getHonorific();
			this.firstName = builder.getFirstName();
			this.middleName = ofNullable(builder.getMiddleName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.initial = ofNullable(builder.getInitial()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.surname = builder.getSurname();
			this.suffix = builder.getSuffix();
		}
		
		@Override
		@RosettaAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		public PersonSequence build() {
			return this;
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder toBuilder() {
			PersonSequence.PersonSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PersonSequence.PersonSequenceBuilder builder) {
			ofNullable(getHonorific()).ifPresent(builder::setHonorific);
			ofNullable(getFirstName()).ifPresent(builder::setFirstName);
			ofNullable(getMiddleName()).ifPresent(builder::setMiddleName);
			ofNullable(getInitial()).ifPresent(builder::setInitial);
			ofNullable(getSurname()).ifPresent(builder::setSurname);
			ofNullable(getSuffix()).ifPresent(builder::setSuffix);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonSequence _that = getType().cast(o);
		
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonSequence {" +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix +
			'}';
		}
	}

	/*********************** Builder Implementation of PersonSequence  ***********************/
	class PersonSequenceBuilderImpl implements PersonSequence.PersonSequenceBuilder {
	
		protected String honorific;
		protected String firstName;
		protected List<String> middleName = new ArrayList<>();
		protected List<String> initial = new ArrayList<>();
		protected String surname;
		protected String suffix;
	
		public PersonSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		@RosettaAttribute("honorific")
		public PersonSequence.PersonSequenceBuilder setHonorific(String honorific) {
			this.honorific = honorific==null?null:honorific;
			return this;
		}
		@Override
		@RosettaAttribute("firstName")
		public PersonSequence.PersonSequenceBuilder setFirstName(String firstName) {
			this.firstName = firstName==null?null:firstName;
			return this;
		}
		@Override
		public PersonSequence.PersonSequenceBuilder addMiddleName(String middleName) {
			if (middleName!=null) this.middleName.add(middleName);
			return this;
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder addMiddleName(String middleName, int _idx) {
			getIndex(this.middleName, _idx, () -> middleName);
			return this;
		}
		@Override 
		public PersonSequence.PersonSequenceBuilder addMiddleName(List<String> middleNames) {
			if (middleNames != null) {
				for (String toAdd : middleNames) {
					this.middleName.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("middleName")
		public PersonSequence.PersonSequenceBuilder setMiddleName(List<String> middleNames) {
			if (middleNames == null)  {
				this.middleName = new ArrayList<>();
			}
			else {
				this.middleName = middleNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder addInitial(String initial) {
			if (initial!=null) this.initial.add(initial);
			return this;
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder addInitial(String initial, int _idx) {
			getIndex(this.initial, _idx, () -> initial);
			return this;
		}
		@Override 
		public PersonSequence.PersonSequenceBuilder addInitial(List<String> initials) {
			if (initials != null) {
				for (String toAdd : initials) {
					this.initial.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("initial")
		public PersonSequence.PersonSequenceBuilder setInitial(List<String> initials) {
			if (initials == null)  {
				this.initial = new ArrayList<>();
			}
			else {
				this.initial = initials.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("surname")
		public PersonSequence.PersonSequenceBuilder setSurname(String surname) {
			this.surname = surname==null?null:surname;
			return this;
		}
		@Override
		@RosettaAttribute("suffix")
		public PersonSequence.PersonSequenceBuilder setSuffix(String suffix) {
			this.suffix = suffix==null?null:suffix;
			return this;
		}
		
		@Override
		public PersonSequence build() {
			return new PersonSequence.PersonSequenceImpl(this);
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonSequence.PersonSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHonorific()!=null) return true;
			if (getFirstName()!=null) return true;
			if (getMiddleName()!=null && !getMiddleName().isEmpty()) return true;
			if (getInitial()!=null && !getInitial().isEmpty()) return true;
			if (getSurname()!=null) return true;
			if (getSuffix()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonSequence.PersonSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PersonSequence.PersonSequenceBuilder o = (PersonSequence.PersonSequenceBuilder) other;
			
			
			merger.mergeBasic(getHonorific(), o.getHonorific(), this::setHonorific);
			merger.mergeBasic(getFirstName(), o.getFirstName(), this::setFirstName);
			merger.mergeBasic(getMiddleName(), o.getMiddleName(), (Consumer<String>) this::addMiddleName);
			merger.mergeBasic(getInitial(), o.getInitial(), (Consumer<String>) this::addInitial);
			merger.mergeBasic(getSurname(), o.getSurname(), this::setSurname);
			merger.mergeBasic(getSuffix(), o.getSuffix(), this::setSuffix);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonSequence _that = getType().cast(o);
		
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonSequenceBuilder {" +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix +
			'}';
		}
	}
}

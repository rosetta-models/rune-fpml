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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractPartyProfile;
import fpml.confirmation.AbstractPartyProfile.AbstractPartyProfileBuilder;
import fpml.confirmation.AbstractPartyProfile.AbstractPartyProfileBuilderImpl;
import fpml.confirmation.AbstractPartyProfile.AbstractPartyProfileImpl;
import fpml.confirmation.PartyProfile;
import fpml.confirmation.PartyProfile.PartyProfileBuilder;
import fpml.confirmation.PartyProfile.PartyProfileBuilderImpl;
import fpml.confirmation.PartyProfile.PartyProfileImpl;
import fpml.confirmation.PartyProfileChoice;
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.meta.PartyProfileMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that describes a party profile record.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyProfile", builder=PartyProfile.PartyProfileBuilderImpl.class, version="${project.version}")
public interface PartyProfile extends AbstractPartyProfile {

	PartyProfileMeta metaData = new PartyProfileMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyProfileChoice> getPartyProfileChoice();

	/*********************** Build Methods  ***********************/
	PartyProfile build();
	
	PartyProfile.PartyProfileBuilder toBuilder();
	
	static PartyProfile.PartyProfileBuilder builder() {
		return new PartyProfile.PartyProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfile> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyProfile> getType() {
		return PartyProfile.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.class, getDocumentation());
		processRosetta(path.newSubPath("partyProfileChoice"), processor, PartyProfileChoice.class, getPartyProfileChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileBuilder extends PartyProfile, AbstractPartyProfile.AbstractPartyProfileBuilder {
		PartyProfileChoice.PartyProfileChoiceBuilder getOrCreatePartyProfileChoice(int _index);
		List<? extends PartyProfileChoice.PartyProfileChoiceBuilder> getPartyProfileChoice();
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier0);
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier1, int _idx);
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier2);
		PartyProfile.PartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier3);
		PartyProfile.PartyProfileBuilder setEffectiveDate(Date effectiveDate);
		PartyProfile.PartyProfileBuilder setPartyReference(PartyReference partyReference);
		PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty0);
		PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		PartyProfile.PartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		PartyProfile.PartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		PartyProfile.PartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice0);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice1, int _idx);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoice2);
		PartyProfile.PartyProfileBuilder setPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoice3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.PartyProfileDocumentationBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("partyProfileChoice"), processor, PartyProfileChoice.PartyProfileChoiceBuilder.class, getPartyProfileChoice());
		}
		

		PartyProfile.PartyProfileBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfile  ***********************/
	class PartyProfileImpl extends AbstractPartyProfile.AbstractPartyProfileImpl implements PartyProfile {
		private final List<? extends PartyProfileChoice> partyProfileChoice;
		
		protected PartyProfileImpl(PartyProfile.PartyProfileBuilder builder) {
			super(builder);
			this.partyProfileChoice = ofNullable(builder.getPartyProfileChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfileChoice")
		public List<? extends PartyProfileChoice> getPartyProfileChoice() {
			return partyProfileChoice;
		}
		
		@Override
		public PartyProfile build() {
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder toBuilder() {
			PartyProfile.PartyProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfile.PartyProfileBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartyProfileChoice()).ifPresent(builder::setPartyProfileChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyProfile _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileChoice, _that.getPartyProfileChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfileChoice != null ? partyProfileChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfile {" +
				"partyProfileChoice=" + this.partyProfileChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PartyProfile  ***********************/
	class PartyProfileBuilderImpl extends AbstractPartyProfile.AbstractPartyProfileBuilderImpl  implements PartyProfile.PartyProfileBuilder {
	
		protected List<PartyProfileChoice.PartyProfileChoiceBuilder> partyProfileChoice = new ArrayList<>();
	
		public PartyProfileBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyProfileChoice")
		public List<? extends PartyProfileChoice.PartyProfileChoiceBuilder> getPartyProfileChoice() {
			return partyProfileChoice;
		}
		
		public PartyProfileChoice.PartyProfileChoiceBuilder getOrCreatePartyProfileChoice(int _index) {
		
			if (partyProfileChoice==null) {
				this.partyProfileChoice = new ArrayList<>();
			}
			PartyProfileChoice.PartyProfileChoiceBuilder result;
			return getIndex(partyProfileChoice, _index, () -> {
						PartyProfileChoice.PartyProfileChoiceBuilder newPartyProfileChoice = PartyProfileChoice.builder();
						return newPartyProfileChoice;
					});
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier) {
			if (partyProfileIdentifier!=null) this.partyProfileIdentifier.add(partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int _idx) {
			getIndex(this.partyProfileIdentifier, _idx, () -> partyProfileIdentifier.toBuilder());
			return this;
		}
		@Override 
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers != null) {
				for (PartyProfileIdentifier toAdd : partyProfileIdentifiers) {
					this.partyProfileIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyProfileIdentifier")
		public PartyProfile.PartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers == null)  {
				this.partyProfileIdentifier = new ArrayList<>();
			}
			else {
				this.partyProfileIdentifier = partyProfileIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public PartyProfile.PartyProfileBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public PartyProfile.PartyProfileBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		public PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public PartyProfile.PartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedParty")
		public PartyProfile.PartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("documentation")
		public PartyProfile.PartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation) {
			this.documentation = documentation==null?null:documentation.toBuilder();
			return this;
		}
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice) {
			if (partyProfileChoice!=null) this.partyProfileChoice.add(partyProfileChoice.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice, int _idx) {
			getIndex(this.partyProfileChoice, _idx, () -> partyProfileChoice.toBuilder());
			return this;
		}
		@Override 
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoices) {
			if (partyProfileChoices != null) {
				for (PartyProfileChoice toAdd : partyProfileChoices) {
					this.partyProfileChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyProfileChoice")
		public PartyProfile.PartyProfileBuilder setPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoices) {
			if (partyProfileChoices == null)  {
				this.partyProfileChoice = new ArrayList<>();
			}
			else {
				this.partyProfileChoice = partyProfileChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PartyProfile build() {
			return new PartyProfile.PartyProfileImpl(this);
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfile.PartyProfileBuilder prune() {
			super.prune();
			partyProfileChoice = partyProfileChoice.stream().filter(b->b!=null).<PartyProfileChoice.PartyProfileChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartyProfileChoice()!=null && getPartyProfileChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfile.PartyProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PartyProfile.PartyProfileBuilder o = (PartyProfile.PartyProfileBuilder) other;
			
			merger.mergeRosetta(getPartyProfileChoice(), o.getPartyProfileChoice(), this::getOrCreatePartyProfileChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyProfile _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileChoice, _that.getPartyProfileChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfileChoice != null ? partyProfileChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileBuilder {" +
				"partyProfileChoice=" + this.partyProfileChoice +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.confirmation.AbstractPartyProfileId;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdBuilder;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl;
import fpml.confirmation.AbstractPartyProfileId.AbstractPartyProfileIdImpl;
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.meta.AbstractPartyProfileMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type that describes a party profile.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractPartyProfile", builder=AbstractPartyProfile.AbstractPartyProfileBuilderImpl.class, version="${project.version}")
public interface AbstractPartyProfile extends AbstractPartyProfileId {

	AbstractPartyProfileMeta metaData = new AbstractPartyProfileMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business date on which the information conveyed within the party profile becomes effective.
	 */
	Date getEffectiveDate();
	/**
	 * The party whose details are being communicated within the notification.
	 */
	PartyReference getPartyReference();
	/**
	 * Other parties that may be related to the receiver party. Examples: custodian or trustee; or, to convey company hierarchy (for use in the context of &#39;blacklists&#39;).
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 * Description of the tax form registered by the party.
	 */
	PartyProfileDocumentation getDocumentation();

	/*********************** Build Methods  ***********************/
	AbstractPartyProfile build();
	
	AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder();
	
	static AbstractPartyProfile.AbstractPartyProfileBuilder builder() {
		return new AbstractPartyProfile.AbstractPartyProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractPartyProfile> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractPartyProfile> getType() {
		return AbstractPartyProfile.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.class, getDocumentation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractPartyProfileBuilder extends AbstractPartyProfile, AbstractPartyProfileId.AbstractPartyProfileIdBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		PartyProfileDocumentation.PartyProfileDocumentationBuilder getOrCreateDocumentation();
		PartyProfileDocumentation.PartyProfileDocumentationBuilder getDocumentation();
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier0);
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier1, int _idx);
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier2);
		AbstractPartyProfile.AbstractPartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier3);
		AbstractPartyProfile.AbstractPartyProfileBuilder setEffectiveDate(Date effectiveDate);
		AbstractPartyProfile.AbstractPartyProfileBuilder setPartyReference(PartyReference partyReference);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty0);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		AbstractPartyProfile.AbstractPartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		AbstractPartyProfile.AbstractPartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.PartyProfileDocumentationBuilder.class, getDocumentation());
		}
		

		AbstractPartyProfile.AbstractPartyProfileBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractPartyProfile  ***********************/
	class AbstractPartyProfileImpl extends AbstractPartyProfileId.AbstractPartyProfileIdImpl implements AbstractPartyProfile {
		private final Date effectiveDate;
		private final PartyReference partyReference;
		private final List<? extends RelatedParty> relatedParty;
		private final PartyProfileDocumentation documentation;
		
		protected AbstractPartyProfileImpl(AbstractPartyProfile.AbstractPartyProfileBuilder builder) {
			super(builder);
			this.effectiveDate = builder.getEffectiveDate();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.documentation = ofNullable(builder.getDocumentation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("documentation")
		public PartyProfileDocumentation getDocumentation() {
			return documentation;
		}
		
		@Override
		public AbstractPartyProfile build() {
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder() {
			AbstractPartyProfile.AbstractPartyProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractPartyProfile.AbstractPartyProfileBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractPartyProfile _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfile {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"documentation=" + this.documentation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractPartyProfile  ***********************/
	class AbstractPartyProfileBuilderImpl extends AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl  implements AbstractPartyProfile.AbstractPartyProfileBuilder {
	
		protected Date effectiveDate;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected PartyProfileDocumentation.PartyProfileDocumentationBuilder documentation;
	
		public AbstractPartyProfileBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("documentation")
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder getDocumentation() {
			return documentation;
		}
		
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder getOrCreateDocumentation() {
			PartyProfileDocumentation.PartyProfileDocumentationBuilder result;
			if (documentation!=null) {
				result = documentation;
			}
			else {
				result = documentation = PartyProfileDocumentation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyProfileIdentifier")
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier) {
			if (partyProfileIdentifier!=null) this.partyProfileIdentifier.add(partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int _idx) {
			getIndex(this.partyProfileIdentifier, _idx, () -> partyProfileIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers != null) {
				for (PartyProfileIdentifier toAdd : partyProfileIdentifiers) {
					this.partyProfileIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractPartyProfile.AbstractPartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public AbstractPartyProfile.AbstractPartyProfileBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedParty")
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractPartyProfile.AbstractPartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation) {
			this.documentation = documentation==null?null:documentation.toBuilder();
			return this;
		}
		
		@Override
		public AbstractPartyProfile build() {
			return new AbstractPartyProfile.AbstractPartyProfileImpl(this);
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder prune() {
			super.prune();
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (documentation!=null && !documentation.prune().hasData()) documentation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDocumentation()!=null && getDocumentation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractPartyProfile.AbstractPartyProfileBuilder o = (AbstractPartyProfile.AbstractPartyProfileBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::setDocumentation);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractPartyProfile _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"documentation=" + this.documentation +
			'}' + " " + super.toString();
		}
	}
}

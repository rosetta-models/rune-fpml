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
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanPartyProfileNotification;
import fpml.confirmation.LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder;
import fpml.confirmation.LoanPartyProfileNotification.LoanPartyProfileNotificationBuilderImpl;
import fpml.confirmation.LoanPartyProfileNotification.LoanPartyProfileNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyProfile;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanPartyProfileNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A profile generated and communicated by parties containing their relevant contact and payment details. This is communicated by parties to anyone who wishes to initiate payments and/or communicate with them.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanPartyProfileNotification", builder=LoanPartyProfileNotification.LoanPartyProfileNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanPartyProfileNotification extends AbstractLoanPartyProfileNotification {

	LoanPartyProfileNotificationMeta metaData = new LoanPartyProfileNotificationMeta();

	/*********************** Getter Methods  ***********************/
	PartyProfile getPartyProfile();
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanPartyProfileNotification build();
	
	LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder toBuilder();
	
	static LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder builder() {
		return new LoanPartyProfileNotification.LoanPartyProfileNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanPartyProfileNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanPartyProfileNotification> getType() {
		return LoanPartyProfileNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("partyProfile"), processor, PartyProfile.class, getPartyProfile());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanPartyProfileNotificationBuilder extends LoanPartyProfileNotification, AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder {
		PartyProfile.PartyProfileBuilder getOrCreatePartyProfile();
		PartyProfile.PartyProfileBuilder getPartyProfile();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setActualBuild(Integer actualBuild);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setHeader(RequestMessageHeader header);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setComments(String comments);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setPartyProfile(PartyProfile partyProfile);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(Party party0);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(Party party1, int _idx);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(List<? extends Party> party2);
		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("partyProfile"), processor, PartyProfile.PartyProfileBuilder.class, getPartyProfile());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanPartyProfileNotification  ***********************/
	class LoanPartyProfileNotificationImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl implements LoanPartyProfileNotification {
		private final PartyProfile partyProfile;
		private final List<? extends Party> party;
		
		protected LoanPartyProfileNotificationImpl(LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder builder) {
			super(builder);
			this.partyProfile = ofNullable(builder.getPartyProfile()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfile")
		public PartyProfile getPartyProfile() {
			return partyProfile;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanPartyProfileNotification build() {
			return this;
		}
		
		@Override
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder toBuilder() {
			LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartyProfile()).ifPresent(builder::setPartyProfile);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyProfileNotification _that = getType().cast(o);
		
			if (!Objects.equals(partyProfile, _that.getPartyProfile())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfile != null ? partyProfile.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyProfileNotification {" +
				"partyProfile=" + this.partyProfile + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanPartyProfileNotification  ***********************/
	class LoanPartyProfileNotificationBuilderImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl  implements LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder {
	
		protected PartyProfile.PartyProfileBuilder partyProfile;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanPartyProfileNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyProfile")
		public PartyProfile.PartyProfileBuilder getPartyProfile() {
			return partyProfile;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder getOrCreatePartyProfile() {
			PartyProfile.PartyProfileBuilder result;
			if (partyProfile!=null) {
				result = partyProfile;
			}
			else {
				result = partyProfile = PartyProfile.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("partyProfile")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setPartyProfile(PartyProfile partyProfile) {
			this.partyProfile = partyProfile==null?null:partyProfile.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanPartyProfileNotification build() {
			return new LoanPartyProfileNotification.LoanPartyProfileNotificationImpl(this);
		}
		
		@Override
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder prune() {
			super.prune();
			if (partyProfile!=null && !partyProfile.prune().hasData()) partyProfile = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartyProfile()!=null && getPartyProfile().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder o = (LoanPartyProfileNotification.LoanPartyProfileNotificationBuilder) other;
			
			merger.mergeRosetta(getPartyProfile(), o.getPartyProfile(), this::setPartyProfile);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyProfileNotification _that = getType().cast(o);
		
			if (!Objects.equals(partyProfile, _that.getPartyProfile())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfile != null ? partyProfile.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyProfileNotificationBuilder {" +
				"partyProfile=" + this.partyProfile + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

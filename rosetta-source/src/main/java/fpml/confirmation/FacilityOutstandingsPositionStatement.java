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
import fpml.confirmation.AbstractLoanStatement;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilder;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilderImpl;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.FacilityOutstandingsPositionStatement;
import fpml.confirmation.FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder;
import fpml.confirmation.FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilderImpl;
import fpml.confirmation.FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementImpl;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.FacilityOutstandingsPositionStatementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents position details (including outstandings) for a single facility. Positions can be stated at the global and (optionally) at the lender-specific level.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityOutstandingsPositionStatement", builder=FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilderImpl.class, version="${project.version}")
public interface FacilityOutstandingsPositionStatement extends AbstractLoanStatement {

	FacilityOutstandingsPositionStatementMeta metaData = new FacilityOutstandingsPositionStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Commitment and outstanding position details for a single facility. Positions can be stated at the global and (optionally) at the lender-specific level.
	 */
	FacilityOutstandingsPosition getFacilityOutstandingsPosition();
	/**
	 * A reference to the party for whom positions are being reported.
	 */
	PartyReference getPositionPartyReference();
	FacilityDetailsModel getFacilityDetailsModel();
	List<? extends LoanContractDetailsModel> getLoanContractDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	FacilityOutstandingsPositionStatement build();
	
	FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder toBuilder();
	
	static FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder builder() {
		return new FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityOutstandingsPositionStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityOutstandingsPositionStatement> getType() {
		return FacilityOutstandingsPositionStatement.class;
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
		processor.processBasic(path.newSubPath("statementDate"), Date.class, getStatementDate(), this);
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
		processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.class, getPositionPartyReference());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityOutstandingsPositionStatementBuilder extends FacilityOutstandingsPositionStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getFacilityOutstandingsPosition();
		PartyReference.PartyReferenceBuilder getOrCreatePositionPartyReference();
		PartyReference.PartyReferenceBuilder getPositionPartyReference();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index);
		List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setExpectedBuild(Integer expectedBuild);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setActualBuild(Integer actualBuild);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setHeader(RequestMessageHeader header);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setValidationModel(ValidationModel validationModel);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setIsCorrection(Boolean isCorrection);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setStatementDate(Date statementDate);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setComments(String comments);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setPositionPartyReference(PartyReference positionPartyReference);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel0);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel1, int _idx);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel2);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModel3);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(Party party0);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(Party party1, int _idx);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(List<? extends Party> party2);
		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("statementDate"), Date.class, getStatementDate(), this);
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
			processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPositionPartyReference());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityOutstandingsPositionStatement  ***********************/
	class FacilityOutstandingsPositionStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements FacilityOutstandingsPositionStatement {
		private final FacilityOutstandingsPosition facilityOutstandingsPosition;
		private final PartyReference positionPartyReference;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends LoanContractDetailsModel> loanContractDetailsModel;
		private final List<? extends Party> party;
		
		protected FacilityOutstandingsPositionStatementImpl(FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder builder) {
			super(builder);
			this.facilityOutstandingsPosition = ofNullable(builder.getFacilityOutstandingsPosition()).map(f->f.build()).orElse(null);
			this.positionPartyReference = ofNullable(builder.getPositionPartyReference()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPosition getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		@RosettaAttribute("positionPartyReference")
		public PartyReference getPositionPartyReference() {
			return positionPartyReference;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public FacilityOutstandingsPositionStatement build() {
			return this;
		}
		
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder toBuilder() {
			FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityOutstandingsPosition()).ifPresent(builder::setFacilityOutstandingsPosition);
			ofNullable(getPositionPartyReference()).ifPresent(builder::setPositionPartyReference);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityOutstandingsPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOutstandingsPositionStatement {" +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityOutstandingsPositionStatement  ***********************/
	class FacilityOutstandingsPositionStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl  implements FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder {
	
		protected FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder facilityOutstandingsPosition;
		protected PartyReference.PartyReferenceBuilder positionPartyReference;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<LoanContractDetailsModel.LoanContractDetailsModelBuilder> loanContractDetailsModel = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public FacilityOutstandingsPositionStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition() {
			FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder result;
			if (facilityOutstandingsPosition!=null) {
				result = facilityOutstandingsPosition;
			}
			else {
				result = facilityOutstandingsPosition = FacilityOutstandingsPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("positionPartyReference")
		public PartyReference.PartyReferenceBuilder getPositionPartyReference() {
			return positionPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePositionPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (positionPartyReference!=null) {
				result = positionPartyReference;
			}
			else {
				result = positionPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public List<? extends LoanContractDetailsModel.LoanContractDetailsModelBuilder> getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel(int _index) {
		
			if (loanContractDetailsModel==null) {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			LoanContractDetailsModel.LoanContractDetailsModelBuilder result;
			return getIndex(loanContractDetailsModel, _index, () -> {
						LoanContractDetailsModel.LoanContractDetailsModelBuilder newLoanContractDetailsModel = LoanContractDetailsModel.builder();
						return newLoanContractDetailsModel;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
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
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			this.facilityOutstandingsPosition = facilityOutstandingsPosition==null?null:facilityOutstandingsPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("positionPartyReference")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setPositionPartyReference(PartyReference positionPartyReference) {
			this.positionPartyReference = positionPartyReference==null?null:positionPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			if (loanContractDetailsModel!=null) this.loanContractDetailsModel.add(loanContractDetailsModel.toBuilder());
			return this;
		}
		
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel, int _idx) {
			getIndex(this.loanContractDetailsModel, _idx, () -> loanContractDetailsModel.toBuilder());
			return this;
		}
		@Override 
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels != null) {
				for (LoanContractDetailsModel toAdd : loanContractDetailsModels) {
					this.loanContractDetailsModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractDetailsModel")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setLoanContractDetailsModel(List<? extends LoanContractDetailsModel> loanContractDetailsModels) {
			if (loanContractDetailsModels == null)  {
				this.loanContractDetailsModel = new ArrayList<>();
			}
			else {
				this.loanContractDetailsModel = loanContractDetailsModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder setParty(List<? extends Party> partys) {
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
		public FacilityOutstandingsPositionStatement build() {
			return new FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementImpl(this);
		}
		
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder prune() {
			super.prune();
			if (facilityOutstandingsPosition!=null && !facilityOutstandingsPosition.prune().hasData()) facilityOutstandingsPosition = null;
			if (positionPartyReference!=null && !positionPartyReference.prune().hasData()) positionPartyReference = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			loanContractDetailsModel = loanContractDetailsModel.stream().filter(b->b!=null).<LoanContractDetailsModel.LoanContractDetailsModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityOutstandingsPosition()!=null && getFacilityOutstandingsPosition().hasData()) return true;
			if (getPositionPartyReference()!=null && getPositionPartyReference().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder o = (FacilityOutstandingsPositionStatement.FacilityOutstandingsPositionStatementBuilder) other;
			
			merger.mergeRosetta(getFacilityOutstandingsPosition(), o.getFacilityOutstandingsPosition(), this::setFacilityOutstandingsPosition);
			merger.mergeRosetta(getPositionPartyReference(), o.getPositionPartyReference(), this::setPositionPartyReference);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::getOrCreateLoanContractDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityOutstandingsPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOutstandingsPositionStatementBuilder {" +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

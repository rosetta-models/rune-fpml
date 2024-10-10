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
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.FacilityPositionStatement;
import fpml.confirmation.FacilityPositionStatement.FacilityPositionStatementBuilder;
import fpml.confirmation.FacilityPositionStatement.FacilityPositionStatementBuilderImpl;
import fpml.confirmation.FacilityPositionStatement.FacilityPositionStatementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.FacilityPositionStatementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A statement containing the commitment amounts for a single facility at the global and (optionally) the lender postion levels, on a specific date.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityPositionStatement", builder=FacilityPositionStatement.FacilityPositionStatementBuilderImpl.class, version="${project.version}")
public interface FacilityPositionStatement extends AbstractLoanStatement {

	FacilityPositionStatementMeta metaData = new FacilityPositionStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Commitment position details for a single facility. Positions can be stated at the global and (optionally) at the lender-specific level.
	 */
	FacilityPosition getFacilityPosition();
	/**
	 * A reference to the party for whom positions are being reported (if applicable position amounts are populated).
	 */
	PartyReference getPositionPartyReference();
	FacilityDetailsModel getFacilityDetailsModel();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	FacilityPositionStatement build();
	
	FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder();
	
	static FacilityPositionStatement.FacilityPositionStatementBuilder builder() {
		return new FacilityPositionStatement.FacilityPositionStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityPositionStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityPositionStatement> getType() {
		return FacilityPositionStatement.class;
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
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.class, getPositionPartyReference());
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityPositionStatementBuilder extends FacilityPositionStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition();
		FacilityPosition.FacilityPositionBuilder getFacilityPosition();
		PartyReference.PartyReferenceBuilder getOrCreatePositionPartyReference();
		PartyReference.PartyReferenceBuilder getPositionPartyReference();
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		FacilityPositionStatement.FacilityPositionStatementBuilder setExpectedBuild(Integer expectedBuild);
		FacilityPositionStatement.FacilityPositionStatementBuilder setActualBuild(Integer actualBuild);
		FacilityPositionStatement.FacilityPositionStatementBuilder setHeader(RequestMessageHeader header);
		FacilityPositionStatement.FacilityPositionStatementBuilder setValidationModel(ValidationModel validationModel);
		FacilityPositionStatement.FacilityPositionStatementBuilder setIsCorrection(Boolean isCorrection);
		FacilityPositionStatement.FacilityPositionStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		FacilityPositionStatement.FacilityPositionStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		FacilityPositionStatement.FacilityPositionStatementBuilder setStatementDate(Date statementDate);
		FacilityPositionStatement.FacilityPositionStatementBuilder setComments(String comments);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPosition(FacilityPosition facilityPosition);
		FacilityPositionStatement.FacilityPositionStatementBuilder setPositionPartyReference(PartyReference positionPartyReference);
		FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party0);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party1, int _idx);
		FacilityPositionStatement.FacilityPositionStatementBuilder addParty(List<? extends Party> party2);
		FacilityPositionStatement.FacilityPositionStatementBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("positionPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPositionPartyReference());
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityPositionStatement.FacilityPositionStatementBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityPositionStatement  ***********************/
	class FacilityPositionStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements FacilityPositionStatement {
		private final FacilityPosition facilityPosition;
		private final PartyReference positionPartyReference;
		private final FacilityDetailsModel facilityDetailsModel;
		private final List<? extends Party> party;
		
		protected FacilityPositionStatementImpl(FacilityPositionStatement.FacilityPositionStatementBuilder builder) {
			super(builder);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).map(f->f.build()).orElse(null);
			this.positionPartyReference = ofNullable(builder.getPositionPartyReference()).map(f->f.build()).orElse(null);
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityPosition getFacilityPosition() {
			return facilityPosition;
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
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public FacilityPositionStatement build() {
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder() {
			FacilityPositionStatement.FacilityPositionStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityPositionStatement.FacilityPositionStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
			ofNullable(getPositionPartyReference()).ifPresent(builder::setPositionPartyReference);
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionStatement {" +
				"facilityPosition=" + this.facilityPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityPositionStatement  ***********************/
	class FacilityPositionStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl  implements FacilityPositionStatement.FacilityPositionStatementBuilder {
	
		protected FacilityPosition.FacilityPositionBuilder facilityPosition;
		protected PartyReference.PartyReferenceBuilder positionPartyReference;
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public FacilityPositionStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityPosition.FacilityPositionBuilder getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition() {
			FacilityPosition.FacilityPositionBuilder result;
			if (facilityPosition!=null) {
				result = facilityPosition;
			}
			else {
				result = facilityPosition = FacilityPosition.builder();
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
		public FacilityPositionStatement.FacilityPositionStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("positionPartyReference")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setPositionPartyReference(PartyReference positionPartyReference) {
			this.positionPartyReference = positionPartyReference==null?null:positionPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public FacilityPositionStatement.FacilityPositionStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public FacilityPositionStatement.FacilityPositionStatementBuilder setParty(List<? extends Party> partys) {
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
		public FacilityPositionStatement build() {
			return new FacilityPositionStatement.FacilityPositionStatementImpl(this);
		}
		
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder prune() {
			super.prune();
			if (facilityPosition!=null && !facilityPosition.prune().hasData()) facilityPosition = null;
			if (positionPartyReference!=null && !positionPartyReference.prune().hasData()) positionPartyReference = null;
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().hasData()) return true;
			if (getPositionPartyReference()!=null && getPositionPartyReference().hasData()) return true;
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPositionStatement.FacilityPositionStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityPositionStatement.FacilityPositionStatementBuilder o = (FacilityPositionStatement.FacilityPositionStatementBuilder) other;
			
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::setFacilityPosition);
			merger.mergeRosetta(getPositionPartyReference(), o.getPositionPartyReference(), this::setPositionPartyReference);
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityPositionStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			if (!Objects.equals(positionPartyReference, _that.getPositionPartyReference())) return false;
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			_result = 31 * _result + (positionPartyReference != null ? positionPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionStatementBuilder {" +
				"facilityPosition=" + this.facilityPosition + ", " +
				"positionPartyReference=" + this.positionPartyReference + ", " +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

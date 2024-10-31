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
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OutstandingContractsStatement;
import fpml.confirmation.OutstandingContractsStatement.OutstandingContractsStatementBuilder;
import fpml.confirmation.OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl;
import fpml.confirmation.OutstandingContractsStatement.OutstandingContractsStatementImpl;
import fpml.confirmation.OutstandingContractsStatementChoice;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.OutstandingContractsStatementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A collection of outstanding loan contract and/or letter of credit structures belonging to a single facility.
 * @version ${project.version}
 */
@RosettaDataType(value="OutstandingContractsStatement", builder=OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl.class, version="${project.version}")
public interface OutstandingContractsStatement extends AbstractLoanStatement {

	OutstandingContractsStatementMeta metaData = new OutstandingContractsStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The facility to which the loan contracts and/or letter of credits belong.
	 */
	FacilityIdentifier getFacilityIdentifier();
	List<? extends OutstandingContractsStatementChoice> getOutstandingContractsStatementChoice();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	OutstandingContractsStatement build();
	
	OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder();
	
	static OutstandingContractsStatement.OutstandingContractsStatementBuilder builder() {
		return new OutstandingContractsStatement.OutstandingContractsStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OutstandingContractsStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OutstandingContractsStatement> getType() {
		return OutstandingContractsStatement.class;
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
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("outstandingContractsStatementChoice"), processor, OutstandingContractsStatementChoice.class, getOutstandingContractsStatementChoice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OutstandingContractsStatementBuilder extends OutstandingContractsStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder getOrCreateOutstandingContractsStatementChoice(int _index);
		List<? extends OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> getOutstandingContractsStatementChoice();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setExpectedBuild(Integer expectedBuild);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setActualBuild(Integer actualBuild);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setHeader(RequestMessageHeader header);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setValidationModel(ValidationModel validationModel);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setIsCorrection(Boolean isCorrection);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setStatementDate(Date statementDate);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setComments(String comments);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice0);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice1, int _idx);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice2);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice3);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party0);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party1, int _idx);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(List<? extends Party> party2);
		OutstandingContractsStatement.OutstandingContractsStatementBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("outstandingContractsStatementChoice"), processor, OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder.class, getOutstandingContractsStatementChoice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		OutstandingContractsStatement.OutstandingContractsStatementBuilder prune();
	}

	/*********************** Immutable Implementation of OutstandingContractsStatement  ***********************/
	class OutstandingContractsStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements OutstandingContractsStatement {
		private final FacilityIdentifier facilityIdentifier;
		private final List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoice;
		private final List<? extends Party> party;
		
		protected OutstandingContractsStatementImpl(OutstandingContractsStatement.OutstandingContractsStatementBuilder builder) {
			super(builder);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.outstandingContractsStatementChoice = ofNullable(builder.getOutstandingContractsStatementChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("outstandingContractsStatementChoice")
		public List<? extends OutstandingContractsStatementChoice> getOutstandingContractsStatementChoice() {
			return outstandingContractsStatementChoice;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public OutstandingContractsStatement build() {
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder() {
			OutstandingContractsStatement.OutstandingContractsStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OutstandingContractsStatement.OutstandingContractsStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getOutstandingContractsStatementChoice()).ifPresent(builder::setOutstandingContractsStatementChoice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OutstandingContractsStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(outstandingContractsStatementChoice, _that.getOutstandingContractsStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (outstandingContractsStatementChoice != null ? outstandingContractsStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatement {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"outstandingContractsStatementChoice=" + this.outstandingContractsStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OutstandingContractsStatement  ***********************/
	class OutstandingContractsStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl  implements OutstandingContractsStatement.OutstandingContractsStatementBuilder {
	
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected List<OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> outstandingContractsStatementChoice = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public OutstandingContractsStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingContractsStatementChoice")
		public List<? extends OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder> getOutstandingContractsStatementChoice() {
			return outstandingContractsStatementChoice;
		}
		
		@Override
		public OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder getOrCreateOutstandingContractsStatementChoice(int _index) {
		
			if (outstandingContractsStatementChoice==null) {
				this.outstandingContractsStatementChoice = new ArrayList<>();
			}
			OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder result;
			return getIndex(outstandingContractsStatementChoice, _index, () -> {
						OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder newOutstandingContractsStatementChoice = OutstandingContractsStatementChoice.builder();
						return newOutstandingContractsStatementChoice;
					});
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
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("facilityIdentifier")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier) {
			this.facilityIdentifier = facilityIdentifier==null?null:facilityIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingContractsStatementChoice")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			if (outstandingContractsStatementChoice!=null) this.outstandingContractsStatementChoice.add(outstandingContractsStatementChoice.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(OutstandingContractsStatementChoice outstandingContractsStatementChoice, int _idx) {
			getIndex(this.outstandingContractsStatementChoice, _idx, () -> outstandingContractsStatementChoice.toBuilder());
			return this;
		}
		@Override 
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoices) {
			if (outstandingContractsStatementChoices != null) {
				for (OutstandingContractsStatementChoice toAdd : outstandingContractsStatementChoices) {
					this.outstandingContractsStatementChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setOutstandingContractsStatementChoice(List<? extends OutstandingContractsStatementChoice> outstandingContractsStatementChoices) {
			if (outstandingContractsStatementChoices == null)  {
				this.outstandingContractsStatementChoice = new ArrayList<>();
			}
			else {
				this.outstandingContractsStatementChoice = outstandingContractsStatementChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder setParty(List<? extends Party> partys) {
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
		public OutstandingContractsStatement build() {
			return new OutstandingContractsStatement.OutstandingContractsStatementImpl(this);
		}
		
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder prune() {
			super.prune();
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			outstandingContractsStatementChoice = outstandingContractsStatementChoice.stream().filter(b->b!=null).<OutstandingContractsStatementChoice.OutstandingContractsStatementChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getOutstandingContractsStatementChoice()!=null && getOutstandingContractsStatementChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OutstandingContractsStatement.OutstandingContractsStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OutstandingContractsStatement.OutstandingContractsStatementBuilder o = (OutstandingContractsStatement.OutstandingContractsStatementBuilder) other;
			
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getOutstandingContractsStatementChoice(), o.getOutstandingContractsStatementChoice(), this::getOrCreateOutstandingContractsStatementChoice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OutstandingContractsStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(outstandingContractsStatementChoice, _that.getOutstandingContractsStatementChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (outstandingContractsStatementChoice != null ? outstandingContractsStatementChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OutstandingContractsStatementBuilder {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"outstandingContractsStatementChoice=" + this.outstandingContractsStatementChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.confirmation.Deal;
import fpml.confirmation.DealStatement;
import fpml.confirmation.DealStatement.DealStatementBuilder;
import fpml.confirmation.DealStatement.DealStatementBuilderImpl;
import fpml.confirmation.DealStatement.DealStatementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.DealStatementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A full set of deal and facility definitions valid as of a specific date.
 * @version ${project.version}
 */
@RosettaDataType(value="DealStatement", builder=DealStatement.DealStatementBuilderImpl.class, version="${project.version}")
public interface DealStatement extends AbstractLoanStatement {

	DealStatementMeta metaData = new DealStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A complete deal structure.
	 */
	Deal getDeal();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	DealStatement build();
	
	DealStatement.DealStatementBuilder toBuilder();
	
	static DealStatement.DealStatementBuilder builder() {
		return new DealStatement.DealStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealStatement> getType() {
		return DealStatement.class;
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
		processRosetta(path.newSubPath("deal"), processor, Deal.class, getDeal());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealStatementBuilder extends DealStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		Deal.DealBuilder getOrCreateDeal();
		Deal.DealBuilder getDeal();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		DealStatement.DealStatementBuilder setExpectedBuild(Integer expectedBuild);
		DealStatement.DealStatementBuilder setActualBuild(Integer actualBuild);
		DealStatement.DealStatementBuilder setHeader(RequestMessageHeader header);
		DealStatement.DealStatementBuilder setValidationModel(ValidationModel validationModel);
		DealStatement.DealStatementBuilder setIsCorrection(Boolean isCorrection);
		DealStatement.DealStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		DealStatement.DealStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		DealStatement.DealStatementBuilder setStatementDate(Date statementDate);
		DealStatement.DealStatementBuilder setComments(String comments);
		DealStatement.DealStatementBuilder setDeal(Deal deal);
		DealStatement.DealStatementBuilder addParty(Party party0);
		DealStatement.DealStatementBuilder addParty(Party party1, int _idx);
		DealStatement.DealStatementBuilder addParty(List<? extends Party> party2);
		DealStatement.DealStatementBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("deal"), processor, Deal.DealBuilder.class, getDeal());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		DealStatement.DealStatementBuilder prune();
	}

	/*********************** Immutable Implementation of DealStatement  ***********************/
	class DealStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements DealStatement {
		private final Deal deal;
		private final List<? extends Party> party;
		
		protected DealStatementImpl(DealStatement.DealStatementBuilder builder) {
			super(builder);
			this.deal = ofNullable(builder.getDeal()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deal")
		public Deal getDeal() {
			return deal;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public DealStatement build() {
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder toBuilder() {
			DealStatement.DealStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealStatement.DealStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeal()).ifPresent(builder::setDeal);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealStatement _that = getType().cast(o);
		
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealStatement {" +
				"deal=" + this.deal + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealStatement  ***********************/
	class DealStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl  implements DealStatement.DealStatementBuilder {
	
		protected Deal.DealBuilder deal;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public DealStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deal")
		public Deal.DealBuilder getDeal() {
			return deal;
		}
		
		@Override
		public Deal.DealBuilder getOrCreateDeal() {
			Deal.DealBuilder result;
			if (deal!=null) {
				result = deal;
			}
			else {
				result = deal = Deal.builder();
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
		public DealStatement.DealStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public DealStatement.DealStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public DealStatement.DealStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public DealStatement.DealStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public DealStatement.DealStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public DealStatement.DealStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public DealStatement.DealStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public DealStatement.DealStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public DealStatement.DealStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("deal")
		public DealStatement.DealStatementBuilder setDeal(Deal deal) {
			this.deal = deal==null?null:deal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("party")
		public DealStatement.DealStatementBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public DealStatement.DealStatementBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public DealStatement.DealStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DealStatement.DealStatementBuilder setParty(List<? extends Party> partys) {
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
		public DealStatement build() {
			return new DealStatement.DealStatementImpl(this);
		}
		
		@Override
		public DealStatement.DealStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealStatement.DealStatementBuilder prune() {
			super.prune();
			if (deal!=null && !deal.prune().hasData()) deal = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeal()!=null && getDeal().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealStatement.DealStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DealStatement.DealStatementBuilder o = (DealStatement.DealStatementBuilder) other;
			
			merger.mergeRosetta(getDeal(), o.getDeal(), this::setDeal);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealStatement _that = getType().cast(o);
		
			if (!Objects.equals(deal, _that.getDeal())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deal != null ? deal.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealStatementBuilder {" +
				"deal=" + this.deal + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.confirmation.AbstractFacility;
import fpml.confirmation.AbstractLoanStatement;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilder;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilderImpl;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityStatement;
import fpml.confirmation.FacilityStatement.FacilityStatementBuilder;
import fpml.confirmation.FacilityStatement.FacilityStatementBuilderImpl;
import fpml.confirmation.FacilityStatement.FacilityStatementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.FacilityStatementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A single facility definition stated as of a certain date.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityStatement", builder=FacilityStatement.FacilityStatementBuilderImpl.class, version="${project.version}")
public interface FacilityStatement extends AbstractLoanStatement {

	FacilityStatementMeta metaData = new FacilityStatementMeta();

	/*********************** Getter Methods  ***********************/
	AbstractFacility getFacilityGroup();
	/**
	 * A legal entity or a subdivision of a legal entity.
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	FacilityStatement build();
	
	FacilityStatement.FacilityStatementBuilder toBuilder();
	
	static FacilityStatement.FacilityStatementBuilder builder() {
		return new FacilityStatement.FacilityStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityStatement> getType() {
		return FacilityStatement.class;
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
		processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.class, getFacilityGroup());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityStatementBuilder extends FacilityStatement, AbstractLoanStatement.AbstractLoanStatementBuilder {
		AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup();
		AbstractFacility.AbstractFacilityBuilder getFacilityGroup();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		FacilityStatement.FacilityStatementBuilder setExpectedBuild(Integer expectedBuild);
		FacilityStatement.FacilityStatementBuilder setActualBuild(Integer actualBuild);
		FacilityStatement.FacilityStatementBuilder setHeader(RequestMessageHeader header);
		FacilityStatement.FacilityStatementBuilder setValidationModel(ValidationModel validationModel);
		FacilityStatement.FacilityStatementBuilder setIsCorrection(Boolean isCorrection);
		FacilityStatement.FacilityStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		FacilityStatement.FacilityStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		FacilityStatement.FacilityStatementBuilder setStatementDate(Date statementDate);
		FacilityStatement.FacilityStatementBuilder setComments(String comments);
		FacilityStatement.FacilityStatementBuilder setFacilityGroup(AbstractFacility facilityGroup);
		FacilityStatement.FacilityStatementBuilder addParty(Party party0);
		FacilityStatement.FacilityStatementBuilder addParty(Party party1, int _idx);
		FacilityStatement.FacilityStatementBuilder addParty(List<? extends Party> party2);
		FacilityStatement.FacilityStatementBuilder setParty(List<? extends Party> party3);

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
			processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.AbstractFacilityBuilder.class, getFacilityGroup());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityStatement.FacilityStatementBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityStatement  ***********************/
	class FacilityStatementImpl extends AbstractLoanStatement.AbstractLoanStatementImpl implements FacilityStatement {
		private final AbstractFacility facilityGroup;
		private final List<? extends Party> party;
		
		protected FacilityStatementImpl(FacilityStatement.FacilityStatementBuilder builder) {
			super(builder);
			this.facilityGroup = ofNullable(builder.getFacilityGroup()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityGroup")
		public AbstractFacility getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public FacilityStatement build() {
			return this;
		}
		
		@Override
		public FacilityStatement.FacilityStatementBuilder toBuilder() {
			FacilityStatement.FacilityStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityStatement.FacilityStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityGroup()).ifPresent(builder::setFacilityGroup);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityStatement {" +
				"facilityGroup=" + this.facilityGroup + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityStatement  ***********************/
	class FacilityStatementBuilderImpl extends AbstractLoanStatement.AbstractLoanStatementBuilderImpl  implements FacilityStatement.FacilityStatementBuilder {
	
		protected AbstractFacility.AbstractFacilityBuilder facilityGroup;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public FacilityStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityGroup")
		public AbstractFacility.AbstractFacilityBuilder getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup() {
			AbstractFacility.AbstractFacilityBuilder result;
			if (facilityGroup!=null) {
				result = facilityGroup;
			}
			else {
				result = facilityGroup = AbstractFacility.builder();
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
		public FacilityStatement.FacilityStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public FacilityStatement.FacilityStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public FacilityStatement.FacilityStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public FacilityStatement.FacilityStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public FacilityStatement.FacilityStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public FacilityStatement.FacilityStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public FacilityStatement.FacilityStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public FacilityStatement.FacilityStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public FacilityStatement.FacilityStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("facilityGroup")
		public FacilityStatement.FacilityStatementBuilder setFacilityGroup(AbstractFacility facilityGroup) {
			this.facilityGroup = facilityGroup==null?null:facilityGroup.toBuilder();
			return this;
		}
		@Override
		public FacilityStatement.FacilityStatementBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityStatement.FacilityStatementBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public FacilityStatement.FacilityStatementBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public FacilityStatement.FacilityStatementBuilder setParty(List<? extends Party> partys) {
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
		public FacilityStatement build() {
			return new FacilityStatement.FacilityStatementImpl(this);
		}
		
		@Override
		public FacilityStatement.FacilityStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityStatement.FacilityStatementBuilder prune() {
			super.prune();
			if (facilityGroup!=null && !facilityGroup.prune().hasData()) facilityGroup = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityGroup()!=null && getFacilityGroup().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityStatement.FacilityStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityStatement.FacilityStatementBuilder o = (FacilityStatement.FacilityStatementBuilder) other;
			
			merger.mergeRosetta(getFacilityGroup(), o.getFacilityGroup(), this::setFacilityGroup);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityStatement _that = getType().cast(o);
		
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityStatementBuilder {" +
				"facilityGroup=" + this.facilityGroup + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

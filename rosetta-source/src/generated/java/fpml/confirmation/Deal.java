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
import fpml.confirmation.Currency;
import fpml.confirmation.Deal;
import fpml.confirmation.Deal.DealBuilder;
import fpml.confirmation.Deal.DealBuilderImpl;
import fpml.confirmation.Deal.DealImpl;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealRulesModel;
import fpml.confirmation.DealSummary;
import fpml.confirmation.DealSummary.DealSummaryBuilder;
import fpml.confirmation.DealSummary.DealSummaryBuilderImpl;
import fpml.confirmation.DealSummary.DealSummaryImpl;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.DealMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A syndicated bank loan deal (credit agreement) definition.
 * @version ${project.version}
 */
@RosettaDataType(value="Deal", builder=Deal.DealBuilderImpl.class, version="${project.version}")
public interface Deal extends DealSummary {

	DealMeta metaData = new DealMeta();

	/*********************** Getter Methods  ***********************/
	DealRulesModel getDealRulesModel();
	List<? extends AbstractFacility> getFacilityGroup();

	/*********************** Build Methods  ***********************/
	Deal build();
	
	Deal.DealBuilder toBuilder();
	
	static Deal.DealBuilder builder() {
		return new Deal.DealBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Deal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Deal> getType() {
		return Deal.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealRolesModel"), processor, DealRolesModel.class, getDealRolesModel());
		processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("dealSummarySequence"), processor, DealSummarySequence.class, getDealSummarySequence());
		processRosetta(path.newSubPath("dealRulesModel"), processor, DealRulesModel.class, getDealRulesModel());
		processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.class, getFacilityGroup());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealBuilder extends Deal, DealSummary.DealSummaryBuilder {
		DealRulesModel.DealRulesModelBuilder getOrCreateDealRulesModel();
		DealRulesModel.DealRulesModelBuilder getDealRulesModel();
		AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup(int _index);
		List<? extends AbstractFacility.AbstractFacilityBuilder> getFacilityGroup();
		Deal.DealBuilder setId(String id);
		Deal.DealBuilder addInstrumentId(InstrumentId instrumentId0);
		Deal.DealBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Deal.DealBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Deal.DealBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Deal.DealBuilder setDescription(String description);
		Deal.DealBuilder setDealRolesModel(DealRolesModel dealRolesModel);
		Deal.DealBuilder setCreditAgreementDate(Date creditAgreementDate);
		Deal.DealBuilder setCurrency(Currency currency);
		Deal.DealBuilder setDealSummarySequence(DealSummarySequence dealSummarySequence);
		Deal.DealBuilder setDealRulesModel(DealRulesModel dealRulesModel);
		Deal.DealBuilder addFacilityGroup(AbstractFacility facilityGroup0);
		Deal.DealBuilder addFacilityGroup(AbstractFacility facilityGroup1, int _idx);
		Deal.DealBuilder addFacilityGroup(List<? extends AbstractFacility> facilityGroup2);
		Deal.DealBuilder setFacilityGroup(List<? extends AbstractFacility> facilityGroup3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealRolesModel"), processor, DealRolesModel.DealRolesModelBuilder.class, getDealRolesModel());
			processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("dealSummarySequence"), processor, DealSummarySequence.DealSummarySequenceBuilder.class, getDealSummarySequence());
			processRosetta(path.newSubPath("dealRulesModel"), processor, DealRulesModel.DealRulesModelBuilder.class, getDealRulesModel());
			processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.AbstractFacilityBuilder.class, getFacilityGroup());
		}
		

		Deal.DealBuilder prune();
	}

	/*********************** Immutable Implementation of Deal  ***********************/
	class DealImpl extends DealSummary.DealSummaryImpl implements Deal {
		private final DealRulesModel dealRulesModel;
		private final List<? extends AbstractFacility> facilityGroup;
		
		protected DealImpl(Deal.DealBuilder builder) {
			super(builder);
			this.dealRulesModel = ofNullable(builder.getDealRulesModel()).map(f->f.build()).orElse(null);
			this.facilityGroup = ofNullable(builder.getFacilityGroup()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealRulesModel")
		public DealRulesModel getDealRulesModel() {
			return dealRulesModel;
		}
		
		@Override
		@RosettaAttribute("facilityGroup")
		public List<? extends AbstractFacility> getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public Deal build() {
			return this;
		}
		
		@Override
		public Deal.DealBuilder toBuilder() {
			Deal.DealBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Deal.DealBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDealRulesModel()).ifPresent(builder::setDealRulesModel);
			ofNullable(getFacilityGroup()).ifPresent(builder::setFacilityGroup);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Deal _that = getType().cast(o);
		
			if (!Objects.equals(dealRulesModel, _that.getDealRulesModel())) return false;
			if (!ListEquals.listEquals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealRulesModel != null ? dealRulesModel.hashCode() : 0);
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Deal {" +
				"dealRulesModel=" + this.dealRulesModel + ", " +
				"facilityGroup=" + this.facilityGroup +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Deal  ***********************/
	class DealBuilderImpl extends DealSummary.DealSummaryBuilderImpl  implements Deal.DealBuilder {
	
		protected DealRulesModel.DealRulesModelBuilder dealRulesModel;
		protected List<AbstractFacility.AbstractFacilityBuilder> facilityGroup = new ArrayList<>();
	
		public DealBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dealRulesModel")
		public DealRulesModel.DealRulesModelBuilder getDealRulesModel() {
			return dealRulesModel;
		}
		
		@Override
		public DealRulesModel.DealRulesModelBuilder getOrCreateDealRulesModel() {
			DealRulesModel.DealRulesModelBuilder result;
			if (dealRulesModel!=null) {
				result = dealRulesModel;
			}
			else {
				result = dealRulesModel = DealRulesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityGroup")
		public List<? extends AbstractFacility.AbstractFacilityBuilder> getFacilityGroup() {
			return facilityGroup;
		}
		
		public AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup(int _index) {
		
			if (facilityGroup==null) {
				this.facilityGroup = new ArrayList<>();
			}
			AbstractFacility.AbstractFacilityBuilder result;
			return getIndex(facilityGroup, _index, () -> {
						AbstractFacility.AbstractFacilityBuilder newFacilityGroup = AbstractFacility.builder();
						return newFacilityGroup;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public Deal.DealBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Deal.DealBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Deal.DealBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public Deal.DealBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public Deal.DealBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("dealRolesModel")
		public Deal.DealBuilder setDealRolesModel(DealRolesModel dealRolesModel) {
			this.dealRolesModel = dealRolesModel==null?null:dealRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Deal.DealBuilder setCreditAgreementDate(Date creditAgreementDate) {
			this.creditAgreementDate = creditAgreementDate==null?null:creditAgreementDate;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Deal.DealBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealSummarySequence")
		public Deal.DealBuilder setDealSummarySequence(DealSummarySequence dealSummarySequence) {
			this.dealSummarySequence = dealSummarySequence==null?null:dealSummarySequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealRulesModel")
		public Deal.DealBuilder setDealRulesModel(DealRulesModel dealRulesModel) {
			this.dealRulesModel = dealRulesModel==null?null:dealRulesModel.toBuilder();
			return this;
		}
		@Override
		public Deal.DealBuilder addFacilityGroup(AbstractFacility facilityGroup) {
			if (facilityGroup!=null) this.facilityGroup.add(facilityGroup.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addFacilityGroup(AbstractFacility facilityGroup, int _idx) {
			getIndex(this.facilityGroup, _idx, () -> facilityGroup.toBuilder());
			return this;
		}
		@Override 
		public Deal.DealBuilder addFacilityGroup(List<? extends AbstractFacility> facilityGroups) {
			if (facilityGroups != null) {
				for (AbstractFacility toAdd : facilityGroups) {
					this.facilityGroup.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityGroup")
		public Deal.DealBuilder setFacilityGroup(List<? extends AbstractFacility> facilityGroups) {
			if (facilityGroups == null)  {
				this.facilityGroup = new ArrayList<>();
			}
			else {
				this.facilityGroup = facilityGroups.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Deal build() {
			return new Deal.DealImpl(this);
		}
		
		@Override
		public Deal.DealBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Deal.DealBuilder prune() {
			super.prune();
			if (dealRulesModel!=null && !dealRulesModel.prune().hasData()) dealRulesModel = null;
			facilityGroup = facilityGroup.stream().filter(b->b!=null).<AbstractFacility.AbstractFacilityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDealRulesModel()!=null && getDealRulesModel().hasData()) return true;
			if (getFacilityGroup()!=null && getFacilityGroup().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Deal.DealBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Deal.DealBuilder o = (Deal.DealBuilder) other;
			
			merger.mergeRosetta(getDealRulesModel(), o.getDealRulesModel(), this::setDealRulesModel);
			merger.mergeRosetta(getFacilityGroup(), o.getFacilityGroup(), this::getOrCreateFacilityGroup);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Deal _that = getType().cast(o);
		
			if (!Objects.equals(dealRulesModel, _that.getDealRulesModel())) return false;
			if (!ListEquals.listEquals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealRulesModel != null ? dealRulesModel.hashCode() : 0);
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealBuilder {" +
				"dealRulesModel=" + this.dealRulesModel + ", " +
				"facilityGroup=" + this.facilityGroup +
			'}' + " " + super.toString();
		}
	}
}

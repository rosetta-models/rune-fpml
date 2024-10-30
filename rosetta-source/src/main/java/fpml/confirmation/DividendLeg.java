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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import fpml.confirmation.DirectionalLegUnderlyer;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl;
import fpml.confirmation.DividendLeg;
import fpml.confirmation.DividendLeg.DividendLegBuilder;
import fpml.confirmation.DividendLeg.DividendLegBuilderImpl;
import fpml.confirmation.DividendLeg.DividendLegImpl;
import fpml.confirmation.DividendPeriodPayment;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import fpml.confirmation.meta.DividendLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Floating Payment Leg of a Dividend Swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DividendLeg", builder=DividendLeg.DividendLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DividendLeg extends DirectionalLegUnderlyer {

	DividendLegMeta metaData = new DividendLegMeta();

	/*********************** Getter Methods  ***********************/
	DeclaredCashAndCashEquivalentDividendPercentageModel getDeclaredCashAndCashEquivalentDividendPercentageModel();
	/**
	 * One to many time bounded dividend payment periods, each with a fixed strike and dividend payment date per period.
	 */
	List<? extends DividendPeriodPayment> getDividendPeriod();
	/**
	 * If present and true, then special dividends and memorial dividends are applicable.
	 */
	Boolean getSpecialDividends();
	/**
	 * If present and true, then material non cash dividends are applicable.
	 */
	Boolean getMaterialDividend();

	/*********************** Build Methods  ***********************/
	DividendLeg build();
	
	DividendLeg.DividendLegBuilder toBuilder();
	
	static DividendLeg.DividendLegBuilder builder() {
		return new DividendLeg.DividendLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendLeg> getType() {
		return DividendLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("declaredCashAndCashEquivalentDividendPercentageModel"), processor, DeclaredCashAndCashEquivalentDividendPercentageModel.class, getDeclaredCashAndCashEquivalentDividendPercentageModel());
		processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodPayment.class, getDividendPeriod());
		processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
		processor.processBasic(path.newSubPath("materialDividend"), Boolean.class, getMaterialDividend(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendLegBuilder extends DividendLeg, DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder {
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getOrCreateDeclaredCashAndCashEquivalentDividendPercentageModel();
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getDeclaredCashAndCashEquivalentDividendPercentageModel();
		DividendPeriodPayment.DividendPeriodPaymentBuilder getOrCreateDividendPeriod(int _index);
		List<? extends DividendPeriodPayment.DividendPeriodPaymentBuilder> getDividendPeriod();
		DividendLeg.DividendLegBuilder setId(String id);
		DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		DividendLeg.DividendLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		DividendLeg.DividendLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		DividendLeg.DividendLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		DividendLeg.DividendLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		DividendLeg.DividendLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		DividendLeg.DividendLegBuilder setUnderlyer(Underlyer underlyer);
		DividendLeg.DividendLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		DividendLeg.DividendLegBuilder setFxFeature(FxFeature fxFeature);
		DividendLeg.DividendLegBuilder setDeclaredCashAndCashEquivalentDividendPercentageModel(DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel);
		DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod0);
		DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod1, int _idx);
		DividendLeg.DividendLegBuilder addDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriod2);
		DividendLeg.DividendLegBuilder setDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriod3);
		DividendLeg.DividendLegBuilder setSpecialDividends(Boolean specialDividends);
		DividendLeg.DividendLegBuilder setMaterialDividend(Boolean materialDividend);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("declaredCashAndCashEquivalentDividendPercentageModel"), processor, DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder.class, getDeclaredCashAndCashEquivalentDividendPercentageModel());
			processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodPayment.DividendPeriodPaymentBuilder.class, getDividendPeriod());
			processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
			processor.processBasic(path.newSubPath("materialDividend"), Boolean.class, getMaterialDividend(), this);
		}
		

		DividendLeg.DividendLegBuilder prune();
	}

	/*********************** Immutable Implementation of DividendLeg  ***********************/
	class DividendLegImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl implements DividendLeg {
		private final DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel;
		private final List<? extends DividendPeriodPayment> dividendPeriod;
		private final Boolean specialDividends;
		private final Boolean materialDividend;
		
		protected DividendLegImpl(DividendLeg.DividendLegBuilder builder) {
			super(builder);
			this.declaredCashAndCashEquivalentDividendPercentageModel = ofNullable(builder.getDeclaredCashAndCashEquivalentDividendPercentageModel()).map(f->f.build()).orElse(null);
			this.dividendPeriod = ofNullable(builder.getDividendPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specialDividends = builder.getSpecialDividends();
			this.materialDividend = builder.getMaterialDividend();
		}
		
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DeclaredCashAndCashEquivalentDividendPercentageModel getDeclaredCashAndCashEquivalentDividendPercentageModel() {
			return declaredCashAndCashEquivalentDividendPercentageModel;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		public List<? extends DividendPeriodPayment> getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		@RosettaAttribute("materialDividend")
		public Boolean getMaterialDividend() {
			return materialDividend;
		}
		
		@Override
		public DividendLeg build() {
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder toBuilder() {
			DividendLeg.DividendLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendLeg.DividendLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeclaredCashAndCashEquivalentDividendPercentageModel()).ifPresent(builder::setDeclaredCashAndCashEquivalentDividendPercentageModel);
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
			ofNullable(getSpecialDividends()).ifPresent(builder::setSpecialDividends);
			ofNullable(getMaterialDividend()).ifPresent(builder::setMaterialDividend);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendLeg _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashAndCashEquivalentDividendPercentageModel, _that.getDeclaredCashAndCashEquivalentDividendPercentageModel())) return false;
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			if (!Objects.equals(materialDividend, _that.getMaterialDividend())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (declaredCashAndCashEquivalentDividendPercentageModel != null ? declaredCashAndCashEquivalentDividendPercentageModel.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			_result = 31 * _result + (materialDividend != null ? materialDividend.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendLeg {" +
				"declaredCashAndCashEquivalentDividendPercentageModel=" + this.declaredCashAndCashEquivalentDividendPercentageModel + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"specialDividends=" + this.specialDividends + ", " +
				"materialDividend=" + this.materialDividend +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendLeg  ***********************/
	class DividendLegBuilderImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl  implements DividendLeg.DividendLegBuilder {
	
		protected DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder declaredCashAndCashEquivalentDividendPercentageModel;
		protected List<DividendPeriodPayment.DividendPeriodPaymentBuilder> dividendPeriod = new ArrayList<>();
		protected Boolean specialDividends;
		protected Boolean materialDividend;
	
		public DividendLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getDeclaredCashAndCashEquivalentDividendPercentageModel() {
			return declaredCashAndCashEquivalentDividendPercentageModel;
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getOrCreateDeclaredCashAndCashEquivalentDividendPercentageModel() {
			DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder result;
			if (declaredCashAndCashEquivalentDividendPercentageModel!=null) {
				result = declaredCashAndCashEquivalentDividendPercentageModel;
			}
			else {
				result = declaredCashAndCashEquivalentDividendPercentageModel = DeclaredCashAndCashEquivalentDividendPercentageModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		public List<? extends DividendPeriodPayment.DividendPeriodPaymentBuilder> getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder getOrCreateDividendPeriod(int _index) {
		
			if (dividendPeriod==null) {
				this.dividendPeriod = new ArrayList<>();
			}
			DividendPeriodPayment.DividendPeriodPaymentBuilder result;
			return getIndex(dividendPeriod, _index, () -> {
						DividendPeriodPayment.DividendPeriodPaymentBuilder newDividendPeriod = DividendPeriodPayment.builder();
						return newDividendPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		@RosettaAttribute("materialDividend")
		public Boolean getMaterialDividend() {
			return materialDividend;
		}
		
		@Override
		@RosettaAttribute("id")
		public DividendLeg.DividendLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DividendLeg.DividendLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DividendLeg.DividendLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public DividendLeg.DividendLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DividendLeg.DividendLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public DividendLeg.DividendLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public DividendLeg.DividendLegBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public DividendLeg.DividendLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public DividendLeg.DividendLegBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DividendLeg.DividendLegBuilder setDeclaredCashAndCashEquivalentDividendPercentageModel(DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel) {
			this.declaredCashAndCashEquivalentDividendPercentageModel = declaredCashAndCashEquivalentDividendPercentageModel==null?null:declaredCashAndCashEquivalentDividendPercentageModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendPeriod")
		public DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod) {
			if (dividendPeriod!=null) this.dividendPeriod.add(dividendPeriod.toBuilder());
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod, int _idx) {
			getIndex(this.dividendPeriod, _idx, () -> dividendPeriod.toBuilder());
			return this;
		}
		@Override 
		public DividendLeg.DividendLegBuilder addDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriods) {
			if (dividendPeriods != null) {
				for (DividendPeriodPayment toAdd : dividendPeriods) {
					this.dividendPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DividendLeg.DividendLegBuilder setDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriods) {
			if (dividendPeriods == null)  {
				this.dividendPeriod = new ArrayList<>();
			}
			else {
				this.dividendPeriod = dividendPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		public DividendLeg.DividendLegBuilder setSpecialDividends(Boolean specialDividends) {
			this.specialDividends = specialDividends==null?null:specialDividends;
			return this;
		}
		@Override
		@RosettaAttribute("materialDividend")
		public DividendLeg.DividendLegBuilder setMaterialDividend(Boolean materialDividend) {
			this.materialDividend = materialDividend==null?null:materialDividend;
			return this;
		}
		
		@Override
		public DividendLeg build() {
			return new DividendLeg.DividendLegImpl(this);
		}
		
		@Override
		public DividendLeg.DividendLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendLeg.DividendLegBuilder prune() {
			super.prune();
			if (declaredCashAndCashEquivalentDividendPercentageModel!=null && !declaredCashAndCashEquivalentDividendPercentageModel.prune().hasData()) declaredCashAndCashEquivalentDividendPercentageModel = null;
			dividendPeriod = dividendPeriod.stream().filter(b->b!=null).<DividendPeriodPayment.DividendPeriodPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeclaredCashAndCashEquivalentDividendPercentageModel()!=null && getDeclaredCashAndCashEquivalentDividendPercentageModel().hasData()) return true;
			if (getDividendPeriod()!=null && getDividendPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecialDividends()!=null) return true;
			if (getMaterialDividend()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendLeg.DividendLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DividendLeg.DividendLegBuilder o = (DividendLeg.DividendLegBuilder) other;
			
			merger.mergeRosetta(getDeclaredCashAndCashEquivalentDividendPercentageModel(), o.getDeclaredCashAndCashEquivalentDividendPercentageModel(), this::setDeclaredCashAndCashEquivalentDividendPercentageModel);
			merger.mergeRosetta(getDividendPeriod(), o.getDividendPeriod(), this::getOrCreateDividendPeriod);
			
			merger.mergeBasic(getSpecialDividends(), o.getSpecialDividends(), this::setSpecialDividends);
			merger.mergeBasic(getMaterialDividend(), o.getMaterialDividend(), this::setMaterialDividend);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendLeg _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashAndCashEquivalentDividendPercentageModel, _that.getDeclaredCashAndCashEquivalentDividendPercentageModel())) return false;
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			if (!Objects.equals(materialDividend, _that.getMaterialDividend())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (declaredCashAndCashEquivalentDividendPercentageModel != null ? declaredCashAndCashEquivalentDividendPercentageModel.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			_result = 31 * _result + (materialDividend != null ? materialDividend.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendLegBuilder {" +
				"declaredCashAndCashEquivalentDividendPercentageModel=" + this.declaredCashAndCashEquivalentDividendPercentageModel + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"specialDividends=" + this.specialDividends + ", " +
				"materialDividend=" + this.materialDividend +
			'}' + " " + super.toString();
		}
	}
}

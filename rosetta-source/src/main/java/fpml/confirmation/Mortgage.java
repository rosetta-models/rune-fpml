package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.AssetPool;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Mortgage;
import fpml.confirmation.Mortgage.MortgageBuilder;
import fpml.confirmation.Mortgage.MortgageBuilderImpl;
import fpml.confirmation.Mortgage.MortgageImpl;
import fpml.confirmation.MortgageSector;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.MortgageMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a mortgage backed security. A type describing a mortgage asset.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Mortgage", builder=Mortgage.MortgageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Mortgage extends UnderlyingAssetType {

	MortgageMeta metaData = new MortgageMeta();

	/*********************** Getter Methods  ***********************/
	LegalEntity getInsurer();
	LegalEntityReference getInsurerReference();
	FixedIncomeSecurityContentModel getFixedIncomeSecurityContentModel();
	BondCalculationModel getBondCalculationModel();
	/**
	 * The initial issued amount of the mortgage obligation.
	 */
	BigDecimal getOriginalPrincipalAmount();
	/**
	 * The morgage pool that is underneath the mortgage obligation.
	 */
	AssetPool getPool();
	/**
	 * The sector classification of the mortgage obligation.
	 */
	MortgageSector getSector();
	/**
	 * The mortgage obligation tranche that is subject to the derivative transaction.
	 */
	String getTranche();

	/*********************** Build Methods  ***********************/
	Mortgage build();
	
	Mortgage.MortgageBuilder toBuilder();
	
	static Mortgage.MortgageBuilder builder() {
		return new Mortgage.MortgageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Mortgage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Mortgage> getType() {
		return Mortgage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("insurer"), processor, LegalEntity.class, getInsurer());
		processRosetta(path.newSubPath("insurerReference"), processor, LegalEntityReference.class, getInsurerReference());
		processRosetta(path.newSubPath("fixedIncomeSecurityContentModel"), processor, FixedIncomeSecurityContentModel.class, getFixedIncomeSecurityContentModel());
		processRosetta(path.newSubPath("bondCalculationModel"), processor, BondCalculationModel.class, getBondCalculationModel());
		processor.processBasic(path.newSubPath("originalPrincipalAmount"), BigDecimal.class, getOriginalPrincipalAmount(), this);
		processRosetta(path.newSubPath("pool"), processor, AssetPool.class, getPool());
		processRosetta(path.newSubPath("sector"), processor, MortgageSector.class, getSector());
		processor.processBasic(path.newSubPath("tranche"), String.class, getTranche(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MortgageBuilder extends Mortgage, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateInsurer();
		LegalEntity.LegalEntityBuilder getInsurer();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateInsurerReference();
		LegalEntityReference.LegalEntityReferenceBuilder getInsurerReference();
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getOrCreateFixedIncomeSecurityContentModel();
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getFixedIncomeSecurityContentModel();
		BondCalculationModel.BondCalculationModelBuilder getOrCreateBondCalculationModel();
		BondCalculationModel.BondCalculationModelBuilder getBondCalculationModel();
		AssetPool.AssetPoolBuilder getOrCreatePool();
		AssetPool.AssetPoolBuilder getPool();
		MortgageSector.MortgageSectorBuilder getOrCreateSector();
		MortgageSector.MortgageSectorBuilder getSector();
		Mortgage.MortgageBuilder setId(String id);
		Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId0);
		Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Mortgage.MortgageBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Mortgage.MortgageBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Mortgage.MortgageBuilder setDescription(String description);
		Mortgage.MortgageBuilder setCurrency(IdentifiedCurrency currency);
		Mortgage.MortgageBuilder setExchangeId(ExchangeId exchangeId);
		Mortgage.MortgageBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Mortgage.MortgageBuilder setDefinition(ProductReference definition);
		Mortgage.MortgageBuilder setInsurer(LegalEntity insurer);
		Mortgage.MortgageBuilder setInsurerReference(LegalEntityReference insurerReference);
		Mortgage.MortgageBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel);
		Mortgage.MortgageBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel);
		Mortgage.MortgageBuilder setOriginalPrincipalAmount(BigDecimal originalPrincipalAmount);
		Mortgage.MortgageBuilder setPool(AssetPool pool);
		Mortgage.MortgageBuilder setSector(MortgageSector sector);
		Mortgage.MortgageBuilder setTranche(String tranche);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("insurer"), processor, LegalEntity.LegalEntityBuilder.class, getInsurer());
			processRosetta(path.newSubPath("insurerReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getInsurerReference());
			processRosetta(path.newSubPath("fixedIncomeSecurityContentModel"), processor, FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder.class, getFixedIncomeSecurityContentModel());
			processRosetta(path.newSubPath("bondCalculationModel"), processor, BondCalculationModel.BondCalculationModelBuilder.class, getBondCalculationModel());
			processor.processBasic(path.newSubPath("originalPrincipalAmount"), BigDecimal.class, getOriginalPrincipalAmount(), this);
			processRosetta(path.newSubPath("pool"), processor, AssetPool.AssetPoolBuilder.class, getPool());
			processRosetta(path.newSubPath("sector"), processor, MortgageSector.MortgageSectorBuilder.class, getSector());
			processor.processBasic(path.newSubPath("tranche"), String.class, getTranche(), this);
		}
		

		Mortgage.MortgageBuilder prune();
	}

	/*********************** Immutable Implementation of Mortgage  ***********************/
	class MortgageImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements Mortgage {
		private final LegalEntity insurer;
		private final LegalEntityReference insurerReference;
		private final FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel;
		private final BondCalculationModel bondCalculationModel;
		private final BigDecimal originalPrincipalAmount;
		private final AssetPool pool;
		private final MortgageSector sector;
		private final String tranche;
		
		protected MortgageImpl(Mortgage.MortgageBuilder builder) {
			super(builder);
			this.insurer = ofNullable(builder.getInsurer()).map(f->f.build()).orElse(null);
			this.insurerReference = ofNullable(builder.getInsurerReference()).map(f->f.build()).orElse(null);
			this.fixedIncomeSecurityContentModel = ofNullable(builder.getFixedIncomeSecurityContentModel()).map(f->f.build()).orElse(null);
			this.bondCalculationModel = ofNullable(builder.getBondCalculationModel()).map(f->f.build()).orElse(null);
			this.originalPrincipalAmount = builder.getOriginalPrincipalAmount();
			this.pool = ofNullable(builder.getPool()).map(f->f.build()).orElse(null);
			this.sector = ofNullable(builder.getSector()).map(f->f.build()).orElse(null);
			this.tranche = builder.getTranche();
		}
		
		@Override
		@RosettaAttribute("insurer")
		public LegalEntity getInsurer() {
			return insurer;
		}
		
		@Override
		@RosettaAttribute("insurerReference")
		public LegalEntityReference getInsurerReference() {
			return insurerReference;
		}
		
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public FixedIncomeSecurityContentModel getFixedIncomeSecurityContentModel() {
			return fixedIncomeSecurityContentModel;
		}
		
		@Override
		@RosettaAttribute("bondCalculationModel")
		public BondCalculationModel getBondCalculationModel() {
			return bondCalculationModel;
		}
		
		@Override
		@RosettaAttribute("originalPrincipalAmount")
		public BigDecimal getOriginalPrincipalAmount() {
			return originalPrincipalAmount;
		}
		
		@Override
		@RosettaAttribute("pool")
		public AssetPool getPool() {
			return pool;
		}
		
		@Override
		@RosettaAttribute("sector")
		public MortgageSector getSector() {
			return sector;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public String getTranche() {
			return tranche;
		}
		
		@Override
		public Mortgage build() {
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder toBuilder() {
			Mortgage.MortgageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Mortgage.MortgageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInsurer()).ifPresent(builder::setInsurer);
			ofNullable(getInsurerReference()).ifPresent(builder::setInsurerReference);
			ofNullable(getFixedIncomeSecurityContentModel()).ifPresent(builder::setFixedIncomeSecurityContentModel);
			ofNullable(getBondCalculationModel()).ifPresent(builder::setBondCalculationModel);
			ofNullable(getOriginalPrincipalAmount()).ifPresent(builder::setOriginalPrincipalAmount);
			ofNullable(getPool()).ifPresent(builder::setPool);
			ofNullable(getSector()).ifPresent(builder::setSector);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Mortgage _that = getType().cast(o);
		
			if (!Objects.equals(insurer, _that.getInsurer())) return false;
			if (!Objects.equals(insurerReference, _that.getInsurerReference())) return false;
			if (!Objects.equals(fixedIncomeSecurityContentModel, _that.getFixedIncomeSecurityContentModel())) return false;
			if (!Objects.equals(bondCalculationModel, _that.getBondCalculationModel())) return false;
			if (!Objects.equals(originalPrincipalAmount, _that.getOriginalPrincipalAmount())) return false;
			if (!Objects.equals(pool, _that.getPool())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (insurer != null ? insurer.hashCode() : 0);
			_result = 31 * _result + (insurerReference != null ? insurerReference.hashCode() : 0);
			_result = 31 * _result + (fixedIncomeSecurityContentModel != null ? fixedIncomeSecurityContentModel.hashCode() : 0);
			_result = 31 * _result + (bondCalculationModel != null ? bondCalculationModel.hashCode() : 0);
			_result = 31 * _result + (originalPrincipalAmount != null ? originalPrincipalAmount.hashCode() : 0);
			_result = 31 * _result + (pool != null ? pool.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Mortgage {" +
				"insurer=" + this.insurer + ", " +
				"insurerReference=" + this.insurerReference + ", " +
				"fixedIncomeSecurityContentModel=" + this.fixedIncomeSecurityContentModel + ", " +
				"bondCalculationModel=" + this.bondCalculationModel + ", " +
				"originalPrincipalAmount=" + this.originalPrincipalAmount + ", " +
				"pool=" + this.pool + ", " +
				"sector=" + this.sector + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Mortgage  ***********************/
	class MortgageBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements Mortgage.MortgageBuilder {
	
		protected LegalEntity.LegalEntityBuilder insurer;
		protected LegalEntityReference.LegalEntityReferenceBuilder insurerReference;
		protected FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder fixedIncomeSecurityContentModel;
		protected BondCalculationModel.BondCalculationModelBuilder bondCalculationModel;
		protected BigDecimal originalPrincipalAmount;
		protected AssetPool.AssetPoolBuilder pool;
		protected MortgageSector.MortgageSectorBuilder sector;
		protected String tranche;
	
		public MortgageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("insurer")
		public LegalEntity.LegalEntityBuilder getInsurer() {
			return insurer;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateInsurer() {
			LegalEntity.LegalEntityBuilder result;
			if (insurer!=null) {
				result = insurer;
			}
			else {
				result = insurer = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("insurerReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getInsurerReference() {
			return insurerReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateInsurerReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (insurerReference!=null) {
				result = insurerReference;
			}
			else {
				result = insurerReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getFixedIncomeSecurityContentModel() {
			return fixedIncomeSecurityContentModel;
		}
		
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getOrCreateFixedIncomeSecurityContentModel() {
			FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder result;
			if (fixedIncomeSecurityContentModel!=null) {
				result = fixedIncomeSecurityContentModel;
			}
			else {
				result = fixedIncomeSecurityContentModel = FixedIncomeSecurityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondCalculationModel")
		public BondCalculationModel.BondCalculationModelBuilder getBondCalculationModel() {
			return bondCalculationModel;
		}
		
		@Override
		public BondCalculationModel.BondCalculationModelBuilder getOrCreateBondCalculationModel() {
			BondCalculationModel.BondCalculationModelBuilder result;
			if (bondCalculationModel!=null) {
				result = bondCalculationModel;
			}
			else {
				result = bondCalculationModel = BondCalculationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalPrincipalAmount")
		public BigDecimal getOriginalPrincipalAmount() {
			return originalPrincipalAmount;
		}
		
		@Override
		@RosettaAttribute("pool")
		public AssetPool.AssetPoolBuilder getPool() {
			return pool;
		}
		
		@Override
		public AssetPool.AssetPoolBuilder getOrCreatePool() {
			AssetPool.AssetPoolBuilder result;
			if (pool!=null) {
				result = pool;
			}
			else {
				result = pool = AssetPool.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sector")
		public MortgageSector.MortgageSectorBuilder getSector() {
			return sector;
		}
		
		@Override
		public MortgageSector.MortgageSectorBuilder getOrCreateSector() {
			MortgageSector.MortgageSectorBuilder result;
			if (sector!=null) {
				result = sector;
			}
			else {
				result = sector = MortgageSector.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tranche")
		public String getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("id")
		public Mortgage.MortgageBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Mortgage.MortgageBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Mortgage.MortgageBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Mortgage.MortgageBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Mortgage.MortgageBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Mortgage.MortgageBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Mortgage.MortgageBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Mortgage.MortgageBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("insurer")
		public Mortgage.MortgageBuilder setInsurer(LegalEntity insurer) {
			this.insurer = insurer==null?null:insurer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("insurerReference")
		public Mortgage.MortgageBuilder setInsurerReference(LegalEntityReference insurerReference) {
			this.insurerReference = insurerReference==null?null:insurerReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public Mortgage.MortgageBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			this.fixedIncomeSecurityContentModel = fixedIncomeSecurityContentModel==null?null:fixedIncomeSecurityContentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bondCalculationModel")
		public Mortgage.MortgageBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel) {
			this.bondCalculationModel = bondCalculationModel==null?null:bondCalculationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalPrincipalAmount")
		public Mortgage.MortgageBuilder setOriginalPrincipalAmount(BigDecimal originalPrincipalAmount) {
			this.originalPrincipalAmount = originalPrincipalAmount==null?null:originalPrincipalAmount;
			return this;
		}
		@Override
		@RosettaAttribute("pool")
		public Mortgage.MortgageBuilder setPool(AssetPool pool) {
			this.pool = pool==null?null:pool.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sector")
		public Mortgage.MortgageBuilder setSector(MortgageSector sector) {
			this.sector = sector==null?null:sector.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tranche")
		public Mortgage.MortgageBuilder setTranche(String tranche) {
			this.tranche = tranche==null?null:tranche;
			return this;
		}
		
		@Override
		public Mortgage build() {
			return new Mortgage.MortgageImpl(this);
		}
		
		@Override
		public Mortgage.MortgageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Mortgage.MortgageBuilder prune() {
			super.prune();
			if (insurer!=null && !insurer.prune().hasData()) insurer = null;
			if (insurerReference!=null && !insurerReference.prune().hasData()) insurerReference = null;
			if (fixedIncomeSecurityContentModel!=null && !fixedIncomeSecurityContentModel.prune().hasData()) fixedIncomeSecurityContentModel = null;
			if (bondCalculationModel!=null && !bondCalculationModel.prune().hasData()) bondCalculationModel = null;
			if (pool!=null && !pool.prune().hasData()) pool = null;
			if (sector!=null && !sector.prune().hasData()) sector = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInsurer()!=null && getInsurer().hasData()) return true;
			if (getInsurerReference()!=null && getInsurerReference().hasData()) return true;
			if (getFixedIncomeSecurityContentModel()!=null && getFixedIncomeSecurityContentModel().hasData()) return true;
			if (getBondCalculationModel()!=null && getBondCalculationModel().hasData()) return true;
			if (getOriginalPrincipalAmount()!=null) return true;
			if (getPool()!=null && getPool().hasData()) return true;
			if (getSector()!=null && getSector().hasData()) return true;
			if (getTranche()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Mortgage.MortgageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Mortgage.MortgageBuilder o = (Mortgage.MortgageBuilder) other;
			
			merger.mergeRosetta(getInsurer(), o.getInsurer(), this::setInsurer);
			merger.mergeRosetta(getInsurerReference(), o.getInsurerReference(), this::setInsurerReference);
			merger.mergeRosetta(getFixedIncomeSecurityContentModel(), o.getFixedIncomeSecurityContentModel(), this::setFixedIncomeSecurityContentModel);
			merger.mergeRosetta(getBondCalculationModel(), o.getBondCalculationModel(), this::setBondCalculationModel);
			merger.mergeRosetta(getPool(), o.getPool(), this::setPool);
			merger.mergeRosetta(getSector(), o.getSector(), this::setSector);
			
			merger.mergeBasic(getOriginalPrincipalAmount(), o.getOriginalPrincipalAmount(), this::setOriginalPrincipalAmount);
			merger.mergeBasic(getTranche(), o.getTranche(), this::setTranche);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Mortgage _that = getType().cast(o);
		
			if (!Objects.equals(insurer, _that.getInsurer())) return false;
			if (!Objects.equals(insurerReference, _that.getInsurerReference())) return false;
			if (!Objects.equals(fixedIncomeSecurityContentModel, _that.getFixedIncomeSecurityContentModel())) return false;
			if (!Objects.equals(bondCalculationModel, _that.getBondCalculationModel())) return false;
			if (!Objects.equals(originalPrincipalAmount, _that.getOriginalPrincipalAmount())) return false;
			if (!Objects.equals(pool, _that.getPool())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (insurer != null ? insurer.hashCode() : 0);
			_result = 31 * _result + (insurerReference != null ? insurerReference.hashCode() : 0);
			_result = 31 * _result + (fixedIncomeSecurityContentModel != null ? fixedIncomeSecurityContentModel.hashCode() : 0);
			_result = 31 * _result + (bondCalculationModel != null ? bondCalculationModel.hashCode() : 0);
			_result = 31 * _result + (originalPrincipalAmount != null ? originalPrincipalAmount.hashCode() : 0);
			_result = 31 * _result + (pool != null ? pool.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MortgageBuilder {" +
				"insurer=" + this.insurer + ", " +
				"insurerReference=" + this.insurerReference + ", " +
				"fixedIncomeSecurityContentModel=" + this.fixedIncomeSecurityContentModel + ", " +
				"bondCalculationModel=" + this.bondCalculationModel + ", " +
				"originalPrincipalAmount=" + this.originalPrincipalAmount + ", " +
				"pool=" + this.pool + ", " +
				"sector=" + this.sector + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder;
import fpml.confirmation.GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilderImpl;
import fpml.confirmation.GenericCommodityAttributesModel.GenericCommodityAttributesModelImpl;
import fpml.confirmation.GenericCommodityDeliveryPeriod;
import fpml.confirmation.GenericCommodityGrade;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.LoadTypeEnum;
import fpml.confirmation.meta.GenericCommodityAttributesModelMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GenericCommodityAttributesModel", builder=GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GenericCommodityAttributesModel extends RosettaModelObject {

	GenericCommodityAttributesModelMeta metaData = new GenericCommodityAttributesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The grade(s) of material which can be delivered in seller&#39;s option.
	 */
	List<? extends GenericCommodityGrade> getGrade();
	/**
	 * Specifies the delivery time periods (normally used for electricity swaps).
	 */
	List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods();
	/**
	 * LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 */
	LoadTypeEnum getLoadType();
	/**
	 * The periodic quantity. Used in conjunction with the quantityFrequency to define quantity per period.
	 */
	BigDecimal getQuantity();
	/**
	 * The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 */
	CommodityQuantityFrequency getQuantityFrequency();
	/**
	 * Fixed price on which fixed payments are based.
	 */
	FixedPrice getFixedPrice();
	/**
	 * Identification of the border(s) or border point(s) of a transportation contract.
	 */
	InterconnectionPoint getInterconnectionPoint();

	/*********************** Build Methods  ***********************/
	GenericCommodityAttributesModel build();
	
	GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder toBuilder();
	
	static GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder builder() {
		return new GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericCommodityAttributesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericCommodityAttributesModel> getType() {
		return GenericCommodityAttributesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.class, getGrade());
		processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.class, getSettlementPeriods());
		processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericCommodityAttributesModelBuilder extends GenericCommodityAttributesModel, RosettaModelObjectBuilder {
		GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int _index);
		List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade();
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int _index);
		List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency();
		FixedPrice.FixedPriceBuilder getOrCreateFixedPrice();
		FixedPrice.FixedPriceBuilder getFixedPrice();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(GenericCommodityGrade grade0);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(GenericCommodityGrade grade1, int _idx);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(List<? extends GenericCommodityGrade> grade2);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setGrade(List<? extends GenericCommodityGrade> grade3);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods0);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods1, int _idx);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods2);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriods3);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setLoadType(LoadTypeEnum loadType);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setQuantity(BigDecimal quantity);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setFixedPrice(FixedPrice fixedPrice);
		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grade"), processor, GenericCommodityGrade.GenericCommodityGradeBuilder.class, getGrade());
			processRosetta(path.newSubPath("settlementPeriods"), processor, GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder.class, getSettlementPeriods());
			processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processRosetta(path.newSubPath("fixedPrice"), processor, FixedPrice.FixedPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
		}
		

		GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder prune();
	}

	/*********************** Immutable Implementation of GenericCommodityAttributesModel  ***********************/
	class GenericCommodityAttributesModelImpl implements GenericCommodityAttributesModel {
		private final List<? extends GenericCommodityGrade> grade;
		private final List<? extends GenericCommodityDeliveryPeriod> settlementPeriods;
		private final LoadTypeEnum loadType;
		private final BigDecimal quantity;
		private final CommodityQuantityFrequency quantityFrequency;
		private final FixedPrice fixedPrice;
		private final InterconnectionPoint interconnectionPoint;
		
		protected GenericCommodityAttributesModelImpl(GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder builder) {
			this.grade = ofNullable(builder.getGrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loadType = builder.getLoadType();
			this.quantity = builder.getQuantity();
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).map(f->f.build()).orElse(null);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("grade")
		public List<? extends GenericCommodityGrade> getGrade() {
			return grade;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommodityQuantityFrequency getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		public FixedPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public GenericCommodityAttributesModel build() {
			return this;
		}
		
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder toBuilder() {
			GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder builder) {
			ofNullable(getGrade()).ifPresent(builder::setGrade);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityAttributesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityAttributesModel {" +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericCommodityAttributesModel  ***********************/
	class GenericCommodityAttributesModelBuilderImpl implements GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder {
	
		protected List<GenericCommodityGrade.GenericCommodityGradeBuilder> grade = new ArrayList<>();
		protected List<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> settlementPeriods = new ArrayList<>();
		protected LoadTypeEnum loadType;
		protected BigDecimal quantity;
		protected CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder quantityFrequency;
		protected FixedPrice.FixedPriceBuilder fixedPrice;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
	
		public GenericCommodityAttributesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("grade")
		public List<? extends GenericCommodityGrade.GenericCommodityGradeBuilder> getGrade() {
			return grade;
		}
		
		@Override
		public GenericCommodityGrade.GenericCommodityGradeBuilder getOrCreateGrade(int _index) {
		
			if (grade==null) {
				this.grade = new ArrayList<>();
			}
			GenericCommodityGrade.GenericCommodityGradeBuilder result;
			return getIndex(grade, _index, () -> {
						GenericCommodityGrade.GenericCommodityGradeBuilder newGrade = GenericCommodityGrade.builder();
						return newGrade;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder getOrCreateSettlementPeriods(int _index) {
		
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder result;
			return getIndex(settlementPeriods, _index, () -> {
						GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder newSettlementPeriods = GenericCommodityDeliveryPeriod.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder result;
			if (quantityFrequency!=null) {
				result = quantityFrequency;
			}
			else {
				result = quantityFrequency = CommodityQuantityFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPrice")
		public FixedPrice.FixedPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder getOrCreateFixedPrice() {
			FixedPrice.FixedPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = FixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grade")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(GenericCommodityGrade grade) {
			if (grade!=null) this.grade.add(grade.toBuilder());
			return this;
		}
		
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(GenericCommodityGrade grade, int _idx) {
			getIndex(this.grade, _idx, () -> grade.toBuilder());
			return this;
		}
		@Override 
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades != null) {
				for (GenericCommodityGrade toAdd : grades) {
					this.grade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setGrade(List<? extends GenericCommodityGrade> grades) {
			if (grades == null)  {
				this.grade = new ArrayList<>();
			}
			else {
				this.grade = grades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods) {
			if (settlementPeriods!=null) this.settlementPeriods.add(settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(GenericCommodityDeliveryPeriod settlementPeriods, int _idx) {
			getIndex(this.settlementPeriods, _idx, () -> settlementPeriods.toBuilder());
			return this;
		}
		@Override 
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder addSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (GenericCommodityDeliveryPeriod toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setSettlementPeriods(List<? extends GenericCommodityDeliveryPeriod> settlementPeriodss) {
			if (settlementPeriodss == null)  {
				this.settlementPeriods = new ArrayList<>();
			}
			else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loadType")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setLoadType(LoadTypeEnum loadType) {
			this.loadType = loadType==null?null:loadType;
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("quantityFrequency")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency) {
			this.quantityFrequency = quantityFrequency==null?null:quantityFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedPrice")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setFixedPrice(FixedPrice fixedPrice) {
			this.fixedPrice = fixedPrice==null?null:fixedPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interconnectionPoint")
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint) {
			this.interconnectionPoint = interconnectionPoint==null?null:interconnectionPoint.toBuilder();
			return this;
		}
		
		@Override
		public GenericCommodityAttributesModel build() {
			return new GenericCommodityAttributesModel.GenericCommodityAttributesModelImpl(this);
		}
		
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder prune() {
			grade = grade.stream().filter(b->b!=null).<GenericCommodityGrade.GenericCommodityGradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityFrequency!=null && !quantityFrequency.prune().hasData()) quantityFrequency = null;
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGrade()!=null && getGrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoadType()!=null) return true;
			if (getQuantity()!=null) return true;
			if (getQuantityFrequency()!=null && getQuantityFrequency().hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder o = (GenericCommodityAttributesModel.GenericCommodityAttributesModelBuilder) other;
			
			merger.mergeRosetta(getGrade(), o.getGrade(), this::getOrCreateGrade);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityAttributesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityAttributesModelBuilder {" +
				"grade=" + this.grade + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"loadType=" + this.loadType + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"fixedPrice=" + this.fixedPrice + ", " +
				"interconnectionPoint=" + this.interconnectionPoint +
			'}';
		}
	}
}

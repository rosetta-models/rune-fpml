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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.MetalDelivery.MetalDeliveryBuilder;
import fpml.confirmation.MetalDelivery.MetalDeliveryBuilderImpl;
import fpml.confirmation.MetalDelivery.MetalDeliveryImpl;
import fpml.confirmation.MetalTitleEnum;
import fpml.confirmation.meta.MetalDeliveryMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery conditions for the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="MetalDelivery", builder=MetalDelivery.MetalDeliveryBuilderImpl.class, version="${project.version}")
public interface MetalDelivery extends RosettaModelObject {

	MetalDeliveryMeta metaData = new MetalDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Delivery Point for a physically settled non-precious metal transaction.
	 */
	CommodityDeliveryPoint getDeliveryLocation();
	/**
	 * &quot;Risk of loss&quot; may also be used, equivalently, on confirmation documents.
	 */
	CommodityDeliveryRisk getRisk();
	/**
	 * The +/- percent tolerance in seller&#39;s option which applies to the total quantity delivered over all shipment periods.
	 */
	BigDecimal getTotalQuantityTolerance();
	/**
	 * The +/- percentage quantity tolerance in seller&#39;s option which applied to each shipment period.
	 */
	BigDecimal getPeriodQuantityTolerance();
	/**
	 * Describes how and when title to the commodity transfers.
	 */
	MetalTitleEnum getTitle();

	/*********************** Build Methods  ***********************/
	MetalDelivery build();
	
	MetalDelivery.MetalDeliveryBuilder toBuilder();
	
	static MetalDelivery.MetalDeliveryBuilder builder() {
		return new MetalDelivery.MetalDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetalDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MetalDelivery> getType() {
		return MetalDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.class, getDeliveryLocation());
		processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.class, getRisk());
		processor.processBasic(path.newSubPath("totalQuantityTolerance"), BigDecimal.class, getTotalQuantityTolerance(), this);
		processor.processBasic(path.newSubPath("periodQuantityTolerance"), BigDecimal.class, getPeriodQuantityTolerance(), this);
		processor.processBasic(path.newSubPath("title"), MetalTitleEnum.class, getTitle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalDeliveryBuilder extends MetalDelivery, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk();
		MetalDelivery.MetalDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint deliveryLocation);
		MetalDelivery.MetalDeliveryBuilder setRisk(CommodityDeliveryRisk risk);
		MetalDelivery.MetalDeliveryBuilder setTotalQuantityTolerance(BigDecimal totalQuantityTolerance);
		MetalDelivery.MetalDeliveryBuilder setPeriodQuantityTolerance(BigDecimal periodQuantityTolerance);
		MetalDelivery.MetalDeliveryBuilder setTitle(MetalTitleEnum title);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getDeliveryLocation());
			processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.CommodityDeliveryRiskBuilder.class, getRisk());
			processor.processBasic(path.newSubPath("totalQuantityTolerance"), BigDecimal.class, getTotalQuantityTolerance(), this);
			processor.processBasic(path.newSubPath("periodQuantityTolerance"), BigDecimal.class, getPeriodQuantityTolerance(), this);
			processor.processBasic(path.newSubPath("title"), MetalTitleEnum.class, getTitle(), this);
		}
		

		MetalDelivery.MetalDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of MetalDelivery  ***********************/
	class MetalDeliveryImpl implements MetalDelivery {
		private final CommodityDeliveryPoint deliveryLocation;
		private final CommodityDeliveryRisk risk;
		private final BigDecimal totalQuantityTolerance;
		private final BigDecimal periodQuantityTolerance;
		private final MetalTitleEnum title;
		
		protected MetalDeliveryImpl(MetalDelivery.MetalDeliveryBuilder builder) {
			this.deliveryLocation = ofNullable(builder.getDeliveryLocation()).map(f->f.build()).orElse(null);
			this.risk = ofNullable(builder.getRisk()).map(f->f.build()).orElse(null);
			this.totalQuantityTolerance = builder.getTotalQuantityTolerance();
			this.periodQuantityTolerance = builder.getPeriodQuantityTolerance();
			this.title = builder.getTitle();
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public CommodityDeliveryPoint getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		@RosettaAttribute("risk")
		public CommodityDeliveryRisk getRisk() {
			return risk;
		}
		
		@Override
		@RosettaAttribute("totalQuantityTolerance")
		public BigDecimal getTotalQuantityTolerance() {
			return totalQuantityTolerance;
		}
		
		@Override
		@RosettaAttribute("periodQuantityTolerance")
		public BigDecimal getPeriodQuantityTolerance() {
			return periodQuantityTolerance;
		}
		
		@Override
		@RosettaAttribute("title")
		public MetalTitleEnum getTitle() {
			return title;
		}
		
		@Override
		public MetalDelivery build() {
			return this;
		}
		
		@Override
		public MetalDelivery.MetalDeliveryBuilder toBuilder() {
			MetalDelivery.MetalDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetalDelivery.MetalDeliveryBuilder builder) {
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
			ofNullable(getRisk()).ifPresent(builder::setRisk);
			ofNullable(getTotalQuantityTolerance()).ifPresent(builder::setTotalQuantityTolerance);
			ofNullable(getPeriodQuantityTolerance()).ifPresent(builder::setPeriodQuantityTolerance);
			ofNullable(getTitle()).ifPresent(builder::setTitle);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			if (!Objects.equals(totalQuantityTolerance, _that.getTotalQuantityTolerance())) return false;
			if (!Objects.equals(periodQuantityTolerance, _that.getPeriodQuantityTolerance())) return false;
			if (!Objects.equals(title, _that.getTitle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			_result = 31 * _result + (totalQuantityTolerance != null ? totalQuantityTolerance.hashCode() : 0);
			_result = 31 * _result + (periodQuantityTolerance != null ? periodQuantityTolerance.hashCode() : 0);
			_result = 31 * _result + (title != null ? title.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalDelivery {" +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"risk=" + this.risk + ", " +
				"totalQuantityTolerance=" + this.totalQuantityTolerance + ", " +
				"periodQuantityTolerance=" + this.periodQuantityTolerance + ", " +
				"title=" + this.title +
			'}';
		}
	}

	/*********************** Builder Implementation of MetalDelivery  ***********************/
	class MetalDeliveryBuilderImpl implements MetalDelivery.MetalDeliveryBuilder {
	
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder deliveryLocation;
		protected CommodityDeliveryRisk.CommodityDeliveryRiskBuilder risk;
		protected BigDecimal totalQuantityTolerance;
		protected BigDecimal periodQuantityTolerance;
		protected MetalTitleEnum title;
	
		public MetalDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("deliveryLocation")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (deliveryLocation!=null) {
				result = deliveryLocation;
			}
			else {
				result = deliveryLocation = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("risk")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk() {
			return risk;
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk() {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder result;
			if (risk!=null) {
				result = risk;
			}
			else {
				result = risk = CommodityDeliveryRisk.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalQuantityTolerance")
		public BigDecimal getTotalQuantityTolerance() {
			return totalQuantityTolerance;
		}
		
		@Override
		@RosettaAttribute("periodQuantityTolerance")
		public BigDecimal getPeriodQuantityTolerance() {
			return periodQuantityTolerance;
		}
		
		@Override
		@RosettaAttribute("title")
		public MetalTitleEnum getTitle() {
			return title;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public MetalDelivery.MetalDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint deliveryLocation) {
			this.deliveryLocation = deliveryLocation==null?null:deliveryLocation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("risk")
		public MetalDelivery.MetalDeliveryBuilder setRisk(CommodityDeliveryRisk risk) {
			this.risk = risk==null?null:risk.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("totalQuantityTolerance")
		public MetalDelivery.MetalDeliveryBuilder setTotalQuantityTolerance(BigDecimal totalQuantityTolerance) {
			this.totalQuantityTolerance = totalQuantityTolerance==null?null:totalQuantityTolerance;
			return this;
		}
		@Override
		@RosettaAttribute("periodQuantityTolerance")
		public MetalDelivery.MetalDeliveryBuilder setPeriodQuantityTolerance(BigDecimal periodQuantityTolerance) {
			this.periodQuantityTolerance = periodQuantityTolerance==null?null:periodQuantityTolerance;
			return this;
		}
		@Override
		@RosettaAttribute("title")
		public MetalDelivery.MetalDeliveryBuilder setTitle(MetalTitleEnum title) {
			this.title = title==null?null:title;
			return this;
		}
		
		@Override
		public MetalDelivery build() {
			return new MetalDelivery.MetalDeliveryImpl(this);
		}
		
		@Override
		public MetalDelivery.MetalDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalDelivery.MetalDeliveryBuilder prune() {
			if (deliveryLocation!=null && !deliveryLocation.prune().hasData()) deliveryLocation = null;
			if (risk!=null && !risk.prune().hasData()) risk = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryLocation()!=null && getDeliveryLocation().hasData()) return true;
			if (getRisk()!=null && getRisk().hasData()) return true;
			if (getTotalQuantityTolerance()!=null) return true;
			if (getPeriodQuantityTolerance()!=null) return true;
			if (getTitle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalDelivery.MetalDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetalDelivery.MetalDeliveryBuilder o = (MetalDelivery.MetalDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			merger.mergeRosetta(getRisk(), o.getRisk(), this::setRisk);
			
			merger.mergeBasic(getTotalQuantityTolerance(), o.getTotalQuantityTolerance(), this::setTotalQuantityTolerance);
			merger.mergeBasic(getPeriodQuantityTolerance(), o.getPeriodQuantityTolerance(), this::setPeriodQuantityTolerance);
			merger.mergeBasic(getTitle(), o.getTitle(), this::setTitle);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			if (!Objects.equals(totalQuantityTolerance, _that.getTotalQuantityTolerance())) return false;
			if (!Objects.equals(periodQuantityTolerance, _that.getPeriodQuantityTolerance())) return false;
			if (!Objects.equals(title, _that.getTitle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			_result = 31 * _result + (totalQuantityTolerance != null ? totalQuantityTolerance.hashCode() : 0);
			_result = 31 * _result + (periodQuantityTolerance != null ? periodQuantityTolerance.hashCode() : 0);
			_result = 31 * _result + (title != null ? title.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalDeliveryBuilder {" +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"risk=" + this.risk + ", " +
				"totalQuantityTolerance=" + this.totalQuantityTolerance + ", " +
				"periodQuantityTolerance=" + this.periodQuantityTolerance + ", " +
				"title=" + this.title +
			'}';
		}
	}
}

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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityProductModelSequence.CommodityProductModelSequenceBuilder;
import fpml.confirmation.CommodityProductModelSequence.CommodityProductModelSequenceBuilderImpl;
import fpml.confirmation.CommodityProductModelSequence.CommodityProductModelSequenceImpl;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.Offset;
import fpml.confirmation.meta.CommodityProductModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityProductModelSequence", builder=CommodityProductModelSequence.CommodityProductModelSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityProductModelSequence extends RosettaModelObject {

	CommodityProductModelSequenceMeta metaData = new CommodityProductModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	CommodityProductModelSequenceChoice getCommodityProductModelSequenceChoice();
	/**
	 * The Delivery Date is a fixed, single day.
	 */
	AdjustableDate getDeliveryDate();
	/**
	 * The Delivery Date is a fixed, single month.
	 */
	Integer getDeliveryDateYearMonth();
	/**
	 * The &#39;deliveryDateRollConvention&#39; specifies, for a Commodity Transaction that references a listed future via the &#39;deliveryDates&#39; element, the day on which the specified future will roll to the next nearby month prior to the expiration of the referenced future. If the future will not roll at all - i.e. the price will be taken from the expiring contract, 0 should be specified here. If the future will roll to the next nearby on the last trading day - i.e. the price will be taken from the next nearby on the last trading day, then 1 should be specified and so on.
	 */
	Offset getDeliveryDateRollConvention();
	/**
	 * The &#39;deliveryDateExpirationConvention&#39; specifies, for a Commodity Transaction that references a listed future via the &#39;deliveryDates&#39; element, the day on which the specified future will expire ahead of the actual expiration of the referenced future. For example: Z21 Contract expires on 19Nov21, with an adjust of 2D the &quot;expire&quot; will be 16Nov21. DeliveryDateRollConvention takes precedence. Example: Pricing on the Z21 Contract with NearbyContractDay and a deliveryDateRoll of 10D, Sampling of the F22 Contract will occur on 8Nov21 through the last Date of the Z21 Contract. With an ExpConvention of 5D, the last sampling date on the F22 contract will be 12Nov21.
	 */
	Offset getDeliveryDateExpirationConvention();

	/*********************** Build Methods  ***********************/
	CommodityProductModelSequence build();
	
	CommodityProductModelSequence.CommodityProductModelSequenceBuilder toBuilder();
	
	static CommodityProductModelSequence.CommodityProductModelSequenceBuilder builder() {
		return new CommodityProductModelSequence.CommodityProductModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityProductModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityProductModelSequence> getType() {
		return CommodityProductModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityProductModelSequenceChoice"), processor, CommodityProductModelSequenceChoice.class, getCommodityProductModelSequenceChoice());
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableDate.class, getDeliveryDate());
		processor.processBasic(path.newSubPath("deliveryDateYearMonth"), Integer.class, getDeliveryDateYearMonth(), this);
		processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.class, getDeliveryDateRollConvention());
		processRosetta(path.newSubPath("deliveryDateExpirationConvention"), processor, Offset.class, getDeliveryDateExpirationConvention());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityProductModelSequenceBuilder extends CommodityProductModelSequence, RosettaModelObjectBuilder {
		CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder getOrCreateCommodityProductModelSequenceChoice();
		CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder getCommodityProductModelSequenceChoice();
		AdjustableDate.AdjustableDateBuilder getOrCreateDeliveryDate();
		AdjustableDate.AdjustableDateBuilder getDeliveryDate();
		Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention();
		Offset.OffsetBuilder getDeliveryDateRollConvention();
		Offset.OffsetBuilder getOrCreateDeliveryDateExpirationConvention();
		Offset.OffsetBuilder getDeliveryDateExpirationConvention();
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder setCommodityProductModelSequenceChoice(CommodityProductModelSequenceChoice commodityProductModelSequenceChoice);
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDate(AdjustableDate deliveryDate);
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateYearMonth(Integer deliveryDateYearMonth);
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateRollConvention(Offset deliveryDateRollConvention);
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateExpirationConvention(Offset deliveryDateExpirationConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityProductModelSequenceChoice"), processor, CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder.class, getCommodityProductModelSequenceChoice());
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getDeliveryDate());
			processor.processBasic(path.newSubPath("deliveryDateYearMonth"), Integer.class, getDeliveryDateYearMonth(), this);
			processRosetta(path.newSubPath("deliveryDateRollConvention"), processor, Offset.OffsetBuilder.class, getDeliveryDateRollConvention());
			processRosetta(path.newSubPath("deliveryDateExpirationConvention"), processor, Offset.OffsetBuilder.class, getDeliveryDateExpirationConvention());
		}
		

		CommodityProductModelSequence.CommodityProductModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityProductModelSequence  ***********************/
	class CommodityProductModelSequenceImpl implements CommodityProductModelSequence {
		private final CommodityProductModelSequenceChoice commodityProductModelSequenceChoice;
		private final AdjustableDate deliveryDate;
		private final Integer deliveryDateYearMonth;
		private final Offset deliveryDateRollConvention;
		private final Offset deliveryDateExpirationConvention;
		
		protected CommodityProductModelSequenceImpl(CommodityProductModelSequence.CommodityProductModelSequenceBuilder builder) {
			this.commodityProductModelSequenceChoice = ofNullable(builder.getCommodityProductModelSequenceChoice()).map(f->f.build()).orElse(null);
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.deliveryDateYearMonth = builder.getDeliveryDateYearMonth();
			this.deliveryDateRollConvention = ofNullable(builder.getDeliveryDateRollConvention()).map(f->f.build()).orElse(null);
			this.deliveryDateExpirationConvention = ofNullable(builder.getDeliveryDateExpirationConvention()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityProductModelSequenceChoice")
		public CommodityProductModelSequenceChoice getCommodityProductModelSequenceChoice() {
			return commodityProductModelSequenceChoice;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("deliveryDateYearMonth")
		public Integer getDeliveryDateYearMonth() {
			return deliveryDateYearMonth;
		}
		
		@Override
		@RosettaAttribute("deliveryDateRollConvention")
		public Offset getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		@RosettaAttribute("deliveryDateExpirationConvention")
		public Offset getDeliveryDateExpirationConvention() {
			return deliveryDateExpirationConvention;
		}
		
		@Override
		public CommodityProductModelSequence build() {
			return this;
		}
		
		@Override
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder toBuilder() {
			CommodityProductModelSequence.CommodityProductModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityProductModelSequence.CommodityProductModelSequenceBuilder builder) {
			ofNullable(getCommodityProductModelSequenceChoice()).ifPresent(builder::setCommodityProductModelSequenceChoice);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getDeliveryDateYearMonth()).ifPresent(builder::setDeliveryDateYearMonth);
			ofNullable(getDeliveryDateRollConvention()).ifPresent(builder::setDeliveryDateRollConvention);
			ofNullable(getDeliveryDateExpirationConvention()).ifPresent(builder::setDeliveryDateExpirationConvention);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductModelSequenceChoice, _that.getCommodityProductModelSequenceChoice())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(deliveryDateYearMonth, _that.getDeliveryDateYearMonth())) return false;
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(deliveryDateExpirationConvention, _that.getDeliveryDateExpirationConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityProductModelSequenceChoice != null ? commodityProductModelSequenceChoice.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryDateYearMonth != null ? deliveryDateYearMonth.hashCode() : 0);
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (deliveryDateExpirationConvention != null ? deliveryDateExpirationConvention.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModelSequence {" +
				"commodityProductModelSequenceChoice=" + this.commodityProductModelSequenceChoice + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"deliveryDateYearMonth=" + this.deliveryDateYearMonth + ", " +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"deliveryDateExpirationConvention=" + this.deliveryDateExpirationConvention +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityProductModelSequence  ***********************/
	class CommodityProductModelSequenceBuilderImpl implements CommodityProductModelSequence.CommodityProductModelSequenceBuilder {
	
		protected CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder commodityProductModelSequenceChoice;
		protected AdjustableDate.AdjustableDateBuilder deliveryDate;
		protected Integer deliveryDateYearMonth;
		protected Offset.OffsetBuilder deliveryDateRollConvention;
		protected Offset.OffsetBuilder deliveryDateExpirationConvention;
	
		public CommodityProductModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityProductModelSequenceChoice")
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder getCommodityProductModelSequenceChoice() {
			return commodityProductModelSequenceChoice;
		}
		
		@Override
		public CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder getOrCreateCommodityProductModelSequenceChoice() {
			CommodityProductModelSequenceChoice.CommodityProductModelSequenceChoiceBuilder result;
			if (commodityProductModelSequenceChoice!=null) {
				result = commodityProductModelSequenceChoice;
			}
			else {
				result = commodityProductModelSequenceChoice = CommodityProductModelSequenceChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableDate.AdjustableDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateDeliveryDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDateYearMonth")
		public Integer getDeliveryDateYearMonth() {
			return deliveryDateYearMonth;
		}
		
		@Override
		@RosettaAttribute("deliveryDateRollConvention")
		public Offset.OffsetBuilder getDeliveryDateRollConvention() {
			return deliveryDateRollConvention;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateDeliveryDateRollConvention() {
			Offset.OffsetBuilder result;
			if (deliveryDateRollConvention!=null) {
				result = deliveryDateRollConvention;
			}
			else {
				result = deliveryDateRollConvention = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryDateExpirationConvention")
		public Offset.OffsetBuilder getDeliveryDateExpirationConvention() {
			return deliveryDateExpirationConvention;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateDeliveryDateExpirationConvention() {
			Offset.OffsetBuilder result;
			if (deliveryDateExpirationConvention!=null) {
				result = deliveryDateExpirationConvention;
			}
			else {
				result = deliveryDateExpirationConvention = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityProductModelSequenceChoice")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder setCommodityProductModelSequenceChoice(CommodityProductModelSequenceChoice commodityProductModelSequenceChoice) {
			this.commodityProductModelSequenceChoice = commodityProductModelSequenceChoice==null?null:commodityProductModelSequenceChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDate")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDate(AdjustableDate deliveryDate) {
			this.deliveryDate = deliveryDate==null?null:deliveryDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDateYearMonth")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateYearMonth(Integer deliveryDateYearMonth) {
			this.deliveryDateYearMonth = deliveryDateYearMonth==null?null:deliveryDateYearMonth;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDateRollConvention")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateRollConvention(Offset deliveryDateRollConvention) {
			this.deliveryDateRollConvention = deliveryDateRollConvention==null?null:deliveryDateRollConvention.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDateExpirationConvention")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder setDeliveryDateExpirationConvention(Offset deliveryDateExpirationConvention) {
			this.deliveryDateExpirationConvention = deliveryDateExpirationConvention==null?null:deliveryDateExpirationConvention.toBuilder();
			return this;
		}
		
		@Override
		public CommodityProductModelSequence build() {
			return new CommodityProductModelSequence.CommodityProductModelSequenceImpl(this);
		}
		
		@Override
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder prune() {
			if (commodityProductModelSequenceChoice!=null && !commodityProductModelSequenceChoice.prune().hasData()) commodityProductModelSequenceChoice = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			if (deliveryDateRollConvention!=null && !deliveryDateRollConvention.prune().hasData()) deliveryDateRollConvention = null;
			if (deliveryDateExpirationConvention!=null && !deliveryDateExpirationConvention.prune().hasData()) deliveryDateExpirationConvention = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityProductModelSequenceChoice()!=null && getCommodityProductModelSequenceChoice().hasData()) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getDeliveryDateYearMonth()!=null) return true;
			if (getDeliveryDateRollConvention()!=null && getDeliveryDateRollConvention().hasData()) return true;
			if (getDeliveryDateExpirationConvention()!=null && getDeliveryDateExpirationConvention().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityProductModelSequence.CommodityProductModelSequenceBuilder o = (CommodityProductModelSequence.CommodityProductModelSequenceBuilder) other;
			
			merger.mergeRosetta(getCommodityProductModelSequenceChoice(), o.getCommodityProductModelSequenceChoice(), this::setCommodityProductModelSequenceChoice);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getDeliveryDateRollConvention(), o.getDeliveryDateRollConvention(), this::setDeliveryDateRollConvention);
			merger.mergeRosetta(getDeliveryDateExpirationConvention(), o.getDeliveryDateExpirationConvention(), this::setDeliveryDateExpirationConvention);
			
			merger.mergeBasic(getDeliveryDateYearMonth(), o.getDeliveryDateYearMonth(), this::setDeliveryDateYearMonth);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductModelSequenceChoice, _that.getCommodityProductModelSequenceChoice())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(deliveryDateYearMonth, _that.getDeliveryDateYearMonth())) return false;
			if (!Objects.equals(deliveryDateRollConvention, _that.getDeliveryDateRollConvention())) return false;
			if (!Objects.equals(deliveryDateExpirationConvention, _that.getDeliveryDateExpirationConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityProductModelSequenceChoice != null ? commodityProductModelSequenceChoice.hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryDateYearMonth != null ? deliveryDateYearMonth.hashCode() : 0);
			_result = 31 * _result + (deliveryDateRollConvention != null ? deliveryDateRollConvention.hashCode() : 0);
			_result = 31 * _result + (deliveryDateExpirationConvention != null ? deliveryDateExpirationConvention.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModelSequenceBuilder {" +
				"commodityProductModelSequenceChoice=" + this.commodityProductModelSequenceChoice + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"deliveryDateYearMonth=" + this.deliveryDateYearMonth + ", " +
				"deliveryDateRollConvention=" + this.deliveryDateRollConvention + ", " +
				"deliveryDateExpirationConvention=" + this.deliveryDateExpirationConvention +
			'}';
		}
	}
}

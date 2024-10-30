package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SettlementPayout;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilder;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilderImpl;
import cdm.product.template.SettlementPayout.SettlementPayoutImpl;
import cdm.product.template.Underlier;
import cdm.product.template.meta.SettlementPayoutMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Represents a forward settling payout. The underlier attribute captures the underlying payout, which is settled according to the settlementTerms attribute (which is part of PayoutBase). Both FX Spot and FX Forward should use this component.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="SettlementPayout", builder=SettlementPayout.SettlementPayoutBuilderImpl.class, version="6.0.0-dev.76")
public interface SettlementPayout extends PayoutBase, GlobalKey {

	SettlementPayoutMeta metaData = new SettlementPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, or the cash settlement of an index rate.
	 */
	Underlier getUnderlier();
	/**
	 * Also called contract month or delivery month. However, it&#39;s not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23.
	 */
	String getDeliveryTerm();
	/**
	 * Contains the information relative to the delivery of the asset.
	 */
	AssetDeliveryInformation getDelivery();
	/**
	 * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
	 */
	CalculationSchedule getSchedule();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	SettlementPayout build();
	
	SettlementPayout.SettlementPayoutBuilder toBuilder();
	
	static SettlementPayout.SettlementPayoutBuilder builder() {
		return new SettlementPayout.SettlementPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPayout> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPayout> getType() {
		return SettlementPayout.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("underlier"), processor, Underlier.class, getUnderlier());
		processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
		processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.class, getDelivery());
		processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.class, getSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPayoutBuilder extends SettlementPayout, PayoutBase.PayoutBaseBuilder {
		Underlier.UnderlierBuilder getOrCreateUnderlier();
		Underlier.UnderlierBuilder getUnderlier();
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getOrCreateDelivery();
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getDelivery();
		CalculationSchedule.CalculationScheduleBuilder getOrCreateSchedule();
		CalculationSchedule.CalculationScheduleBuilder getSchedule();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		SettlementPayout.SettlementPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		SettlementPayout.SettlementPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		SettlementPayout.SettlementPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		SettlementPayout.SettlementPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		SettlementPayout.SettlementPayoutBuilder setUnderlier(Underlier underlier);
		SettlementPayout.SettlementPayoutBuilder setDeliveryTerm(String deliveryTerm);
		SettlementPayout.SettlementPayoutBuilder setDelivery(AssetDeliveryInformation delivery);
		SettlementPayout.SettlementPayoutBuilder setSchedule(CalculationSchedule schedule);
		SettlementPayout.SettlementPayoutBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("underlier"), processor, Underlier.UnderlierBuilder.class, getUnderlier());
			processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
			processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.AssetDeliveryInformationBuilder.class, getDelivery());
			processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.CalculationScheduleBuilder.class, getSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		SettlementPayout.SettlementPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPayout  ***********************/
	class SettlementPayoutImpl extends PayoutBase.PayoutBaseImpl implements SettlementPayout {
		private final Underlier underlier;
		private final String deliveryTerm;
		private final AssetDeliveryInformation delivery;
		private final CalculationSchedule schedule;
		private final MetaFields meta;
		
		protected SettlementPayoutImpl(SettlementPayout.SettlementPayoutBuilder builder) {
			super(builder);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.deliveryTerm = builder.getDeliveryTerm();
			this.delivery = ofNullable(builder.getDelivery()).map(f->f.build()).orElse(null);
			this.schedule = ofNullable(builder.getSchedule()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlier")
		public Underlier getUnderlier() {
			return underlier;
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("delivery")
		public AssetDeliveryInformation getDelivery() {
			return delivery;
		}
		
		@Override
		@RosettaAttribute("schedule")
		public CalculationSchedule getSchedule() {
			return schedule;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public SettlementPayout build() {
			return this;
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder toBuilder() {
			SettlementPayout.SettlementPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPayout.SettlementPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getDeliveryTerm()).ifPresent(builder::setDeliveryTerm);
			ofNullable(getDelivery()).ifPresent(builder::setDelivery);
			ofNullable(getSchedule()).ifPresent(builder::setSchedule);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPayout _that = getType().cast(o);
		
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPayout {" +
				"underlier=" + this.underlier + ", " +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"delivery=" + this.delivery + ", " +
				"schedule=" + this.schedule + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementPayout  ***********************/
	class SettlementPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements SettlementPayout.SettlementPayoutBuilder, GlobalKeyBuilder {
	
		protected Underlier.UnderlierBuilder underlier;
		protected String deliveryTerm;
		protected AssetDeliveryInformation.AssetDeliveryInformationBuilder delivery;
		protected CalculationSchedule.CalculationScheduleBuilder schedule;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public SettlementPayoutBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlier")
		public Underlier.UnderlierBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Underlier.UnderlierBuilder getOrCreateUnderlier() {
			Underlier.UnderlierBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Underlier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("delivery")
		public AssetDeliveryInformation.AssetDeliveryInformationBuilder getDelivery() {
			return delivery;
		}
		
		@Override
		public AssetDeliveryInformation.AssetDeliveryInformationBuilder getOrCreateDelivery() {
			AssetDeliveryInformation.AssetDeliveryInformationBuilder result;
			if (delivery!=null) {
				result = delivery;
			}
			else {
				result = delivery = AssetDeliveryInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("schedule")
		public CalculationSchedule.CalculationScheduleBuilder getSchedule() {
			return schedule;
		}
		
		@Override
		public CalculationSchedule.CalculationScheduleBuilder getOrCreateSchedule() {
			CalculationSchedule.CalculationScheduleBuilder result;
			if (schedule!=null) {
				result = schedule;
			}
			else {
				result = schedule = CalculationSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		public SettlementPayout.SettlementPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priceQuantity")
		public SettlementPayout.SettlementPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity) {
			this.priceQuantity = priceQuantity==null?null:priceQuantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalPayment")
		public SettlementPayout.SettlementPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment) {
			this.principalPayment = principalPayment==null?null:principalPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementTerms")
		public SettlementPayout.SettlementPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlier")
		public SettlementPayout.SettlementPayoutBuilder setUnderlier(Underlier underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliveryTerm")
		public SettlementPayout.SettlementPayoutBuilder setDeliveryTerm(String deliveryTerm) {
			this.deliveryTerm = deliveryTerm==null?null:deliveryTerm;
			return this;
		}
		@Override
		@RosettaAttribute("delivery")
		public SettlementPayout.SettlementPayoutBuilder setDelivery(AssetDeliveryInformation delivery) {
			this.delivery = delivery==null?null:delivery.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("schedule")
		public SettlementPayout.SettlementPayoutBuilder setSchedule(CalculationSchedule schedule) {
			this.schedule = schedule==null?null:schedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("meta")
		public SettlementPayout.SettlementPayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public SettlementPayout build() {
			return new SettlementPayout.SettlementPayoutImpl(this);
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPayout.SettlementPayoutBuilder prune() {
			super.prune();
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			if (delivery!=null && !delivery.prune().hasData()) delivery = null;
			if (schedule!=null && !schedule.prune().hasData()) schedule = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getDeliveryTerm()!=null) return true;
			if (getDelivery()!=null && getDelivery().hasData()) return true;
			if (getSchedule()!=null && getSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPayout.SettlementPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SettlementPayout.SettlementPayoutBuilder o = (SettlementPayout.SettlementPayoutBuilder) other;
			
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getDelivery(), o.getDelivery(), this::setDelivery);
			merger.mergeRosetta(getSchedule(), o.getSchedule(), this::setSchedule);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getDeliveryTerm(), o.getDeliveryTerm(), this::setDeliveryTerm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPayout _that = getType().cast(o);
		
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPayoutBuilder {" +
				"underlier=" + this.underlier + ", " +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"delivery=" + this.delivery + ", " +
				"schedule=" + this.schedule + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}

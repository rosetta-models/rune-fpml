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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.NovationAmountsModel;
import fpml.confirmation.NovationDatesModel;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.NovationTermsModel;
import fpml.confirmation.Payment;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.TradeNovationContent.TradeNovationContentBuilder;
import fpml.confirmation.TradeNovationContent.TradeNovationContentBuilderImpl;
import fpml.confirmation.TradeNovationContent.TradeNovationContentImpl;
import fpml.confirmation.TradeNovationContentSequence0;
import fpml.confirmation.TradeNovationContentSequence1;
import fpml.confirmation.meta.TradeNovationContentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a novation.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNovationContent", builder=TradeNovationContent.TradeNovationContentBuilderImpl.class, version="${project.version}")
public interface TradeNovationContent extends AbstractEvent {

	TradeNovationContentMeta metaData = new TradeNovationContentMeta();

	/*********************** Getter Methods  ***********************/
	NewTradeModel getNewTradeModel();
	TradeNovationContentSequence0 getTradeNovationContentSequence0();
	TradeNovationContentSequence1 getTradeNovationContentSequence1();
	NovationRolesModel getNovationRolesModel();
	NovationDatesModel getNovationDatesModel();
	NovationAmountsModel getNovationAmountsModel();
	NovationTermsModel getNovationTermsModel();
	/**
	 * Describes a payment made in settlement of the novation.
	 */
	Payment getPayment();

	/*********************** Build Methods  ***********************/
	TradeNovationContent build();
	
	TradeNovationContent.TradeNovationContentBuilder toBuilder();
	
	static TradeNovationContent.TradeNovationContentBuilder builder() {
		return new TradeNovationContent.TradeNovationContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNovationContent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNovationContent> getType() {
		return TradeNovationContent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.class, getNewTradeModel());
		processRosetta(path.newSubPath("tradeNovationContentSequence0"), processor, TradeNovationContentSequence0.class, getTradeNovationContentSequence0());
		processRosetta(path.newSubPath("tradeNovationContentSequence1"), processor, TradeNovationContentSequence1.class, getTradeNovationContentSequence1());
		processRosetta(path.newSubPath("novationRolesModel"), processor, NovationRolesModel.class, getNovationRolesModel());
		processRosetta(path.newSubPath("novationDatesModel"), processor, NovationDatesModel.class, getNovationDatesModel());
		processRosetta(path.newSubPath("novationAmountsModel"), processor, NovationAmountsModel.class, getNovationAmountsModel());
		processRosetta(path.newSubPath("novationTermsModel"), processor, NovationTermsModel.class, getNovationTermsModel());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNovationContentBuilder extends TradeNovationContent, AbstractEvent.AbstractEventBuilder {
		NewTradeModel.NewTradeModelBuilder getOrCreateNewTradeModel();
		NewTradeModel.NewTradeModelBuilder getNewTradeModel();
		TradeNovationContentSequence0.TradeNovationContentSequence0Builder getOrCreateTradeNovationContentSequence0();
		TradeNovationContentSequence0.TradeNovationContentSequence0Builder getTradeNovationContentSequence0();
		TradeNovationContentSequence1.TradeNovationContentSequence1Builder getOrCreateTradeNovationContentSequence1();
		TradeNovationContentSequence1.TradeNovationContentSequence1Builder getTradeNovationContentSequence1();
		NovationRolesModel.NovationRolesModelBuilder getOrCreateNovationRolesModel();
		NovationRolesModel.NovationRolesModelBuilder getNovationRolesModel();
		NovationDatesModel.NovationDatesModelBuilder getOrCreateNovationDatesModel();
		NovationDatesModel.NovationDatesModelBuilder getNovationDatesModel();
		NovationAmountsModel.NovationAmountsModelBuilder getOrCreateNovationAmountsModel();
		NovationAmountsModel.NovationAmountsModelBuilder getNovationAmountsModel();
		NovationTermsModel.NovationTermsModelBuilder getOrCreateNovationTermsModel();
		NovationTermsModel.NovationTermsModelBuilder getNovationTermsModel();
		Payment.PaymentBuilder getOrCreatePayment();
		Payment.PaymentBuilder getPayment();
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		TradeNovationContent.TradeNovationContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		TradeNovationContent.TradeNovationContentBuilder setNewTradeModel(NewTradeModel newTradeModel);
		TradeNovationContent.TradeNovationContentBuilder setTradeNovationContentSequence0(TradeNovationContentSequence0 tradeNovationContentSequence0);
		TradeNovationContent.TradeNovationContentBuilder setTradeNovationContentSequence1(TradeNovationContentSequence1 tradeNovationContentSequence1);
		TradeNovationContent.TradeNovationContentBuilder setNovationRolesModel(NovationRolesModel novationRolesModel);
		TradeNovationContent.TradeNovationContentBuilder setNovationDatesModel(NovationDatesModel novationDatesModel);
		TradeNovationContent.TradeNovationContentBuilder setNovationAmountsModel(NovationAmountsModel novationAmountsModel);
		TradeNovationContent.TradeNovationContentBuilder setNovationTermsModel(NovationTermsModel novationTermsModel);
		TradeNovationContent.TradeNovationContentBuilder setPayment(Payment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.NewTradeModelBuilder.class, getNewTradeModel());
			processRosetta(path.newSubPath("tradeNovationContentSequence0"), processor, TradeNovationContentSequence0.TradeNovationContentSequence0Builder.class, getTradeNovationContentSequence0());
			processRosetta(path.newSubPath("tradeNovationContentSequence1"), processor, TradeNovationContentSequence1.TradeNovationContentSequence1Builder.class, getTradeNovationContentSequence1());
			processRosetta(path.newSubPath("novationRolesModel"), processor, NovationRolesModel.NovationRolesModelBuilder.class, getNovationRolesModel());
			processRosetta(path.newSubPath("novationDatesModel"), processor, NovationDatesModel.NovationDatesModelBuilder.class, getNovationDatesModel());
			processRosetta(path.newSubPath("novationAmountsModel"), processor, NovationAmountsModel.NovationAmountsModelBuilder.class, getNovationAmountsModel());
			processRosetta(path.newSubPath("novationTermsModel"), processor, NovationTermsModel.NovationTermsModelBuilder.class, getNovationTermsModel());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeNovationContent.TradeNovationContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeNovationContent  ***********************/
	class TradeNovationContentImpl extends AbstractEvent.AbstractEventImpl implements TradeNovationContent {
		private final NewTradeModel newTradeModel;
		private final TradeNovationContentSequence0 tradeNovationContentSequence0;
		private final TradeNovationContentSequence1 tradeNovationContentSequence1;
		private final NovationRolesModel novationRolesModel;
		private final NovationDatesModel novationDatesModel;
		private final NovationAmountsModel novationAmountsModel;
		private final NovationTermsModel novationTermsModel;
		private final Payment payment;
		
		protected TradeNovationContentImpl(TradeNovationContent.TradeNovationContentBuilder builder) {
			super(builder);
			this.newTradeModel = ofNullable(builder.getNewTradeModel()).map(f->f.build()).orElse(null);
			this.tradeNovationContentSequence0 = ofNullable(builder.getTradeNovationContentSequence0()).map(f->f.build()).orElse(null);
			this.tradeNovationContentSequence1 = ofNullable(builder.getTradeNovationContentSequence1()).map(f->f.build()).orElse(null);
			this.novationRolesModel = ofNullable(builder.getNovationRolesModel()).map(f->f.build()).orElse(null);
			this.novationDatesModel = ofNullable(builder.getNovationDatesModel()).map(f->f.build()).orElse(null);
			this.novationAmountsModel = ofNullable(builder.getNovationAmountsModel()).map(f->f.build()).orElse(null);
			this.novationTermsModel = ofNullable(builder.getNovationTermsModel()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("newTradeModel")
		public NewTradeModel getNewTradeModel() {
			return newTradeModel;
		}
		
		@Override
		@RosettaAttribute("tradeNovationContentSequence0")
		public TradeNovationContentSequence0 getTradeNovationContentSequence0() {
			return tradeNovationContentSequence0;
		}
		
		@Override
		@RosettaAttribute("tradeNovationContentSequence1")
		public TradeNovationContentSequence1 getTradeNovationContentSequence1() {
			return tradeNovationContentSequence1;
		}
		
		@Override
		@RosettaAttribute("novationRolesModel")
		public NovationRolesModel getNovationRolesModel() {
			return novationRolesModel;
		}
		
		@Override
		@RosettaAttribute("novationDatesModel")
		public NovationDatesModel getNovationDatesModel() {
			return novationDatesModel;
		}
		
		@Override
		@RosettaAttribute("novationAmountsModel")
		public NovationAmountsModel getNovationAmountsModel() {
			return novationAmountsModel;
		}
		
		@Override
		@RosettaAttribute("novationTermsModel")
		public NovationTermsModel getNovationTermsModel() {
			return novationTermsModel;
		}
		
		@Override
		@RosettaAttribute("payment")
		public Payment getPayment() {
			return payment;
		}
		
		@Override
		public TradeNovationContent build() {
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder toBuilder() {
			TradeNovationContent.TradeNovationContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNovationContent.TradeNovationContentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNewTradeModel()).ifPresent(builder::setNewTradeModel);
			ofNullable(getTradeNovationContentSequence0()).ifPresent(builder::setTradeNovationContentSequence0);
			ofNullable(getTradeNovationContentSequence1()).ifPresent(builder::setTradeNovationContentSequence1);
			ofNullable(getNovationRolesModel()).ifPresent(builder::setNovationRolesModel);
			ofNullable(getNovationDatesModel()).ifPresent(builder::setNovationDatesModel);
			ofNullable(getNovationAmountsModel()).ifPresent(builder::setNovationAmountsModel);
			ofNullable(getNovationTermsModel()).ifPresent(builder::setNovationTermsModel);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNovationContent _that = getType().cast(o);
		
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			if (!Objects.equals(tradeNovationContentSequence0, _that.getTradeNovationContentSequence0())) return false;
			if (!Objects.equals(tradeNovationContentSequence1, _that.getTradeNovationContentSequence1())) return false;
			if (!Objects.equals(novationRolesModel, _that.getNovationRolesModel())) return false;
			if (!Objects.equals(novationDatesModel, _that.getNovationDatesModel())) return false;
			if (!Objects.equals(novationAmountsModel, _that.getNovationAmountsModel())) return false;
			if (!Objects.equals(novationTermsModel, _that.getNovationTermsModel())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			_result = 31 * _result + (tradeNovationContentSequence0 != null ? tradeNovationContentSequence0.hashCode() : 0);
			_result = 31 * _result + (tradeNovationContentSequence1 != null ? tradeNovationContentSequence1.hashCode() : 0);
			_result = 31 * _result + (novationRolesModel != null ? novationRolesModel.hashCode() : 0);
			_result = 31 * _result + (novationDatesModel != null ? novationDatesModel.hashCode() : 0);
			_result = 31 * _result + (novationAmountsModel != null ? novationAmountsModel.hashCode() : 0);
			_result = 31 * _result + (novationTermsModel != null ? novationTermsModel.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContent {" +
				"newTradeModel=" + this.newTradeModel + ", " +
				"tradeNovationContentSequence0=" + this.tradeNovationContentSequence0 + ", " +
				"tradeNovationContentSequence1=" + this.tradeNovationContentSequence1 + ", " +
				"novationRolesModel=" + this.novationRolesModel + ", " +
				"novationDatesModel=" + this.novationDatesModel + ", " +
				"novationAmountsModel=" + this.novationAmountsModel + ", " +
				"novationTermsModel=" + this.novationTermsModel + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeNovationContent  ***********************/
	class TradeNovationContentBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements TradeNovationContent.TradeNovationContentBuilder {
	
		protected NewTradeModel.NewTradeModelBuilder newTradeModel;
		protected TradeNovationContentSequence0.TradeNovationContentSequence0Builder tradeNovationContentSequence0;
		protected TradeNovationContentSequence1.TradeNovationContentSequence1Builder tradeNovationContentSequence1;
		protected NovationRolesModel.NovationRolesModelBuilder novationRolesModel;
		protected NovationDatesModel.NovationDatesModelBuilder novationDatesModel;
		protected NovationAmountsModel.NovationAmountsModelBuilder novationAmountsModel;
		protected NovationTermsModel.NovationTermsModelBuilder novationTermsModel;
		protected Payment.PaymentBuilder payment;
	
		public TradeNovationContentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("newTradeModel")
		public NewTradeModel.NewTradeModelBuilder getNewTradeModel() {
			return newTradeModel;
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder getOrCreateNewTradeModel() {
			NewTradeModel.NewTradeModelBuilder result;
			if (newTradeModel!=null) {
				result = newTradeModel;
			}
			else {
				result = newTradeModel = NewTradeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeNovationContentSequence0")
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder getTradeNovationContentSequence0() {
			return tradeNovationContentSequence0;
		}
		
		@Override
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder getOrCreateTradeNovationContentSequence0() {
			TradeNovationContentSequence0.TradeNovationContentSequence0Builder result;
			if (tradeNovationContentSequence0!=null) {
				result = tradeNovationContentSequence0;
			}
			else {
				result = tradeNovationContentSequence0 = TradeNovationContentSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeNovationContentSequence1")
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder getTradeNovationContentSequence1() {
			return tradeNovationContentSequence1;
		}
		
		@Override
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder getOrCreateTradeNovationContentSequence1() {
			TradeNovationContentSequence1.TradeNovationContentSequence1Builder result;
			if (tradeNovationContentSequence1!=null) {
				result = tradeNovationContentSequence1;
			}
			else {
				result = tradeNovationContentSequence1 = TradeNovationContentSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationRolesModel")
		public NovationRolesModel.NovationRolesModelBuilder getNovationRolesModel() {
			return novationRolesModel;
		}
		
		@Override
		public NovationRolesModel.NovationRolesModelBuilder getOrCreateNovationRolesModel() {
			NovationRolesModel.NovationRolesModelBuilder result;
			if (novationRolesModel!=null) {
				result = novationRolesModel;
			}
			else {
				result = novationRolesModel = NovationRolesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationDatesModel")
		public NovationDatesModel.NovationDatesModelBuilder getNovationDatesModel() {
			return novationDatesModel;
		}
		
		@Override
		public NovationDatesModel.NovationDatesModelBuilder getOrCreateNovationDatesModel() {
			NovationDatesModel.NovationDatesModelBuilder result;
			if (novationDatesModel!=null) {
				result = novationDatesModel;
			}
			else {
				result = novationDatesModel = NovationDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationAmountsModel")
		public NovationAmountsModel.NovationAmountsModelBuilder getNovationAmountsModel() {
			return novationAmountsModel;
		}
		
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder getOrCreateNovationAmountsModel() {
			NovationAmountsModel.NovationAmountsModelBuilder result;
			if (novationAmountsModel!=null) {
				result = novationAmountsModel;
			}
			else {
				result = novationAmountsModel = NovationAmountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationTermsModel")
		public NovationTermsModel.NovationTermsModelBuilder getNovationTermsModel() {
			return novationTermsModel;
		}
		
		@Override
		public NovationTermsModel.NovationTermsModelBuilder getOrCreateNovationTermsModel() {
			NovationTermsModel.NovationTermsModelBuilder result;
			if (novationTermsModel!=null) {
				result = novationTermsModel;
			}
			else {
				result = novationTermsModel = NovationTermsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		public Payment.PaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment() {
			Payment.PaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeNovationContent.TradeNovationContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public TradeNovationContent.TradeNovationContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("newTradeModel")
		public TradeNovationContent.TradeNovationContentBuilder setNewTradeModel(NewTradeModel newTradeModel) {
			this.newTradeModel = newTradeModel==null?null:newTradeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeNovationContentSequence0")
		public TradeNovationContent.TradeNovationContentBuilder setTradeNovationContentSequence0(TradeNovationContentSequence0 tradeNovationContentSequence0) {
			this.tradeNovationContentSequence0 = tradeNovationContentSequence0==null?null:tradeNovationContentSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeNovationContentSequence1")
		public TradeNovationContent.TradeNovationContentBuilder setTradeNovationContentSequence1(TradeNovationContentSequence1 tradeNovationContentSequence1) {
			this.tradeNovationContentSequence1 = tradeNovationContentSequence1==null?null:tradeNovationContentSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationRolesModel")
		public TradeNovationContent.TradeNovationContentBuilder setNovationRolesModel(NovationRolesModel novationRolesModel) {
			this.novationRolesModel = novationRolesModel==null?null:novationRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationDatesModel")
		public TradeNovationContent.TradeNovationContentBuilder setNovationDatesModel(NovationDatesModel novationDatesModel) {
			this.novationDatesModel = novationDatesModel==null?null:novationDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationAmountsModel")
		public TradeNovationContent.TradeNovationContentBuilder setNovationAmountsModel(NovationAmountsModel novationAmountsModel) {
			this.novationAmountsModel = novationAmountsModel==null?null:novationAmountsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationTermsModel")
		public TradeNovationContent.TradeNovationContentBuilder setNovationTermsModel(NovationTermsModel novationTermsModel) {
			this.novationTermsModel = novationTermsModel==null?null:novationTermsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public TradeNovationContent.TradeNovationContentBuilder setPayment(Payment payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		
		@Override
		public TradeNovationContent build() {
			return new TradeNovationContent.TradeNovationContentImpl(this);
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder prune() {
			super.prune();
			if (newTradeModel!=null && !newTradeModel.prune().hasData()) newTradeModel = null;
			if (tradeNovationContentSequence0!=null && !tradeNovationContentSequence0.prune().hasData()) tradeNovationContentSequence0 = null;
			if (tradeNovationContentSequence1!=null && !tradeNovationContentSequence1.prune().hasData()) tradeNovationContentSequence1 = null;
			if (novationRolesModel!=null && !novationRolesModel.prune().hasData()) novationRolesModel = null;
			if (novationDatesModel!=null && !novationDatesModel.prune().hasData()) novationDatesModel = null;
			if (novationAmountsModel!=null && !novationAmountsModel.prune().hasData()) novationAmountsModel = null;
			if (novationTermsModel!=null && !novationTermsModel.prune().hasData()) novationTermsModel = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNewTradeModel()!=null && getNewTradeModel().hasData()) return true;
			if (getTradeNovationContentSequence0()!=null && getTradeNovationContentSequence0().hasData()) return true;
			if (getTradeNovationContentSequence1()!=null && getTradeNovationContentSequence1().hasData()) return true;
			if (getNovationRolesModel()!=null && getNovationRolesModel().hasData()) return true;
			if (getNovationDatesModel()!=null && getNovationDatesModel().hasData()) return true;
			if (getNovationAmountsModel()!=null && getNovationAmountsModel().hasData()) return true;
			if (getNovationTermsModel()!=null && getNovationTermsModel().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContent.TradeNovationContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeNovationContent.TradeNovationContentBuilder o = (TradeNovationContent.TradeNovationContentBuilder) other;
			
			merger.mergeRosetta(getNewTradeModel(), o.getNewTradeModel(), this::setNewTradeModel);
			merger.mergeRosetta(getTradeNovationContentSequence0(), o.getTradeNovationContentSequence0(), this::setTradeNovationContentSequence0);
			merger.mergeRosetta(getTradeNovationContentSequence1(), o.getTradeNovationContentSequence1(), this::setTradeNovationContentSequence1);
			merger.mergeRosetta(getNovationRolesModel(), o.getNovationRolesModel(), this::setNovationRolesModel);
			merger.mergeRosetta(getNovationDatesModel(), o.getNovationDatesModel(), this::setNovationDatesModel);
			merger.mergeRosetta(getNovationAmountsModel(), o.getNovationAmountsModel(), this::setNovationAmountsModel);
			merger.mergeRosetta(getNovationTermsModel(), o.getNovationTermsModel(), this::setNovationTermsModel);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNovationContent _that = getType().cast(o);
		
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			if (!Objects.equals(tradeNovationContentSequence0, _that.getTradeNovationContentSequence0())) return false;
			if (!Objects.equals(tradeNovationContentSequence1, _that.getTradeNovationContentSequence1())) return false;
			if (!Objects.equals(novationRolesModel, _that.getNovationRolesModel())) return false;
			if (!Objects.equals(novationDatesModel, _that.getNovationDatesModel())) return false;
			if (!Objects.equals(novationAmountsModel, _that.getNovationAmountsModel())) return false;
			if (!Objects.equals(novationTermsModel, _that.getNovationTermsModel())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			_result = 31 * _result + (tradeNovationContentSequence0 != null ? tradeNovationContentSequence0.hashCode() : 0);
			_result = 31 * _result + (tradeNovationContentSequence1 != null ? tradeNovationContentSequence1.hashCode() : 0);
			_result = 31 * _result + (novationRolesModel != null ? novationRolesModel.hashCode() : 0);
			_result = 31 * _result + (novationDatesModel != null ? novationDatesModel.hashCode() : 0);
			_result = 31 * _result + (novationAmountsModel != null ? novationAmountsModel.hashCode() : 0);
			_result = 31 * _result + (novationTermsModel != null ? novationTermsModel.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentBuilder {" +
				"newTradeModel=" + this.newTradeModel + ", " +
				"tradeNovationContentSequence0=" + this.tradeNovationContentSequence0 + ", " +
				"tradeNovationContentSequence1=" + this.tradeNovationContentSequence1 + ", " +
				"novationRolesModel=" + this.novationRolesModel + ", " +
				"novationDatesModel=" + this.novationDatesModel + ", " +
				"novationAmountsModel=" + this.novationAmountsModel + ", " +
				"novationTermsModel=" + this.novationTermsModel + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}

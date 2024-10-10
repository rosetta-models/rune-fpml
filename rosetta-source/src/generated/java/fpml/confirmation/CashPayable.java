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
import fpml.confirmation.CashPayable;
import fpml.confirmation.CashPayable.CashPayableBuilder;
import fpml.confirmation.CashPayable.CashPayableBuilderImpl;
import fpml.confirmation.CashPayable.CashPayableImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.TaxWithholding;
import fpml.confirmation.meta.CashPayableMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure taht represents payable cash, together with reference to any withholding tax being applied. This is used as a generic cash flow container across all loan business events (within the event header).
 * @version ${project.version}
 */
@RosettaDataType(value="CashPayable", builder=CashPayable.CashPayableBuilderImpl.class, version="${project.version}")
public interface CashPayable extends RosettaModelObject {

	CashPayableMeta metaData = new CashPayableMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The cash amount payable, net of all tax withholding. This amount represents the funds to be wired from &#39;payer&#39; to &#39;receiver&#39; as a result of the underlying business event.
	 */
	NonNegativeMoney getNetAmount();
	/**
	 * Details of the tax being withheld.
	 */
	List<? extends TaxWithholding> getTaxWithholding();

	/*********************** Build Methods  ***********************/
	CashPayable build();
	
	CashPayable.CashPayableBuilder toBuilder();
	
	static CashPayable.CashPayableBuilder builder() {
		return new CashPayable.CashPayableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashPayable> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashPayable> getType() {
		return CashPayable.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("netAmount"), processor, NonNegativeMoney.class, getNetAmount());
		processRosetta(path.newSubPath("taxWithholding"), processor, TaxWithholding.class, getTaxWithholding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashPayableBuilder extends CashPayable, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNetAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getNetAmount();
		TaxWithholding.TaxWithholdingBuilder getOrCreateTaxWithholding(int _index);
		List<? extends TaxWithholding.TaxWithholdingBuilder> getTaxWithholding();
		CashPayable.CashPayableBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CashPayable.CashPayableBuilder setNetAmount(NonNegativeMoney netAmount);
		CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding0);
		CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding1, int _idx);
		CashPayable.CashPayableBuilder addTaxWithholding(List<? extends TaxWithholding> taxWithholding2);
		CashPayable.CashPayableBuilder setTaxWithholding(List<? extends TaxWithholding> taxWithholding3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("netAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNetAmount());
			processRosetta(path.newSubPath("taxWithholding"), processor, TaxWithholding.TaxWithholdingBuilder.class, getTaxWithholding());
		}
		

		CashPayable.CashPayableBuilder prune();
	}

	/*********************** Immutable Implementation of CashPayable  ***********************/
	class CashPayableImpl implements CashPayable {
		private final PayerReceiverModel payerReceiverModel;
		private final NonNegativeMoney netAmount;
		private final List<? extends TaxWithholding> taxWithholding;
		
		protected CashPayableImpl(CashPayable.CashPayableBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.netAmount = ofNullable(builder.getNetAmount()).map(f->f.build()).orElse(null);
			this.taxWithholding = ofNullable(builder.getTaxWithholding()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("netAmount")
		public NonNegativeMoney getNetAmount() {
			return netAmount;
		}
		
		@Override
		@RosettaAttribute("taxWithholding")
		public List<? extends TaxWithholding> getTaxWithholding() {
			return taxWithholding;
		}
		
		@Override
		public CashPayable build() {
			return this;
		}
		
		@Override
		public CashPayable.CashPayableBuilder toBuilder() {
			CashPayable.CashPayableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashPayable.CashPayableBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getNetAmount()).ifPresent(builder::setNetAmount);
			ofNullable(getTaxWithholding()).ifPresent(builder::setTaxWithholding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPayable _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!ListEquals.listEquals(taxWithholding, _that.getTaxWithholding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (taxWithholding != null ? taxWithholding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPayable {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"netAmount=" + this.netAmount + ", " +
				"taxWithholding=" + this.taxWithholding +
			'}';
		}
	}

	/*********************** Builder Implementation of CashPayable  ***********************/
	class CashPayableBuilderImpl implements CashPayable.CashPayableBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected NonNegativeMoney.NonNegativeMoneyBuilder netAmount;
		protected List<TaxWithholding.TaxWithholdingBuilder> taxWithholding = new ArrayList<>();
	
		public CashPayableBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("netAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNetAmount() {
			return netAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNetAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (netAmount!=null) {
				result = netAmount;
			}
			else {
				result = netAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taxWithholding")
		public List<? extends TaxWithholding.TaxWithholdingBuilder> getTaxWithholding() {
			return taxWithholding;
		}
		
		public TaxWithholding.TaxWithholdingBuilder getOrCreateTaxWithholding(int _index) {
		
			if (taxWithholding==null) {
				this.taxWithholding = new ArrayList<>();
			}
			TaxWithholding.TaxWithholdingBuilder result;
			return getIndex(taxWithholding, _index, () -> {
						TaxWithholding.TaxWithholdingBuilder newTaxWithholding = TaxWithholding.builder();
						return newTaxWithholding;
					});
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CashPayable.CashPayableBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("netAmount")
		public CashPayable.CashPayableBuilder setNetAmount(NonNegativeMoney netAmount) {
			this.netAmount = netAmount==null?null:netAmount.toBuilder();
			return this;
		}
		@Override
		public CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding) {
			if (taxWithholding!=null) this.taxWithholding.add(taxWithholding.toBuilder());
			return this;
		}
		
		@Override
		public CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding, int _idx) {
			getIndex(this.taxWithholding, _idx, () -> taxWithholding.toBuilder());
			return this;
		}
		@Override 
		public CashPayable.CashPayableBuilder addTaxWithholding(List<? extends TaxWithholding> taxWithholdings) {
			if (taxWithholdings != null) {
				for (TaxWithholding toAdd : taxWithholdings) {
					this.taxWithholding.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("taxWithholding")
		public CashPayable.CashPayableBuilder setTaxWithholding(List<? extends TaxWithholding> taxWithholdings) {
			if (taxWithholdings == null)  {
				this.taxWithholding = new ArrayList<>();
			}
			else {
				this.taxWithholding = taxWithholdings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CashPayable build() {
			return new CashPayable.CashPayableImpl(this);
		}
		
		@Override
		public CashPayable.CashPayableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPayable.CashPayableBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (netAmount!=null && !netAmount.prune().hasData()) netAmount = null;
			taxWithholding = taxWithholding.stream().filter(b->b!=null).<TaxWithholding.TaxWithholdingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getNetAmount()!=null && getNetAmount().hasData()) return true;
			if (getTaxWithholding()!=null && getTaxWithholding().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPayable.CashPayableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashPayable.CashPayableBuilder o = (CashPayable.CashPayableBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getNetAmount(), o.getNetAmount(), this::setNetAmount);
			merger.mergeRosetta(getTaxWithholding(), o.getTaxWithholding(), this::getOrCreateTaxWithholding);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPayable _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!ListEquals.listEquals(taxWithholding, _that.getTaxWithholding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (taxWithholding != null ? taxWithholding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPayableBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"netAmount=" + this.netAmount + ", " +
				"taxWithholding=" + this.taxWithholding +
			'}';
		}
	}
}

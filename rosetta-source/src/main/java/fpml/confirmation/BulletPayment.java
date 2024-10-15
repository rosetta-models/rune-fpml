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
import fpml.confirmation.BulletPayment;
import fpml.confirmation.BulletPayment.BulletPaymentBuilder;
import fpml.confirmation.BulletPayment.BulletPaymentBuilderImpl;
import fpml.confirmation.BulletPayment.BulletPaymentImpl;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.BulletPaymentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A product to represent a single known payment. A product to represent a single cashflow.
 * @version ${project.version}
 */
@RosettaDataType(value="BulletPayment", builder=BulletPayment.BulletPaymentBuilderImpl.class, version="${project.version}")
public interface BulletPayment extends Product {

	BulletPaymentMeta metaData = new BulletPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A known payment between two parties.
	 */
	Payment getPayment();

	/*********************** Build Methods  ***********************/
	BulletPayment build();
	
	BulletPayment.BulletPaymentBuilder toBuilder();
	
	static BulletPayment.BulletPaymentBuilder builder() {
		return new BulletPayment.BulletPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BulletPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BulletPayment> getType() {
		return BulletPayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BulletPaymentBuilder extends BulletPayment, Product.ProductBuilder {
		Payment.PaymentBuilder getOrCreatePayment();
		Payment.PaymentBuilder getPayment();
		BulletPayment.BulletPaymentBuilder setProductModel(ProductModel productModel);
		BulletPayment.BulletPaymentBuilder setId(String id);
		BulletPayment.BulletPaymentBuilder setPayment(Payment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		BulletPayment.BulletPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of BulletPayment  ***********************/
	class BulletPaymentImpl extends Product.ProductImpl implements BulletPayment {
		private final Payment payment;
		
		protected BulletPaymentImpl(BulletPayment.BulletPaymentBuilder builder) {
			super(builder);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		public Payment getPayment() {
			return payment;
		}
		
		@Override
		public BulletPayment build() {
			return this;
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder toBuilder() {
			BulletPayment.BulletPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BulletPayment.BulletPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BulletPayment _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BulletPayment {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BulletPayment  ***********************/
	class BulletPaymentBuilderImpl extends Product.ProductBuilderImpl  implements BulletPayment.BulletPaymentBuilder {
	
		protected Payment.PaymentBuilder payment;
	
		public BulletPaymentBuilderImpl() {
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
		@RosettaAttribute("productModel")
		public BulletPayment.BulletPaymentBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BulletPayment.BulletPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public BulletPayment.BulletPaymentBuilder setPayment(Payment payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		
		@Override
		public BulletPayment build() {
			return new BulletPayment.BulletPaymentImpl(this);
		}
		
		@Override
		public BulletPayment.BulletPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BulletPayment.BulletPaymentBuilder prune() {
			super.prune();
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BulletPayment.BulletPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BulletPayment.BulletPaymentBuilder o = (BulletPayment.BulletPaymentBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BulletPayment _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BulletPaymentBuilder {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}

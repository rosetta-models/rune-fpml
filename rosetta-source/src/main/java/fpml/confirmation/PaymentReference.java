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
import fpml.confirmation.PaymentReference;
import fpml.confirmation.PaymentReference.PaymentReferenceBuilder;
import fpml.confirmation.PaymentReference.PaymentReferenceBuilderImpl;
import fpml.confirmation.PaymentReference.PaymentReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PaymentReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a payment.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentReference", builder=PaymentReference.PaymentReferenceBuilderImpl.class, version="${project.version}")
public interface PaymentReference extends Reference {

	PaymentReferenceMeta metaData = new PaymentReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PaymentReference build();
	
	PaymentReference.PaymentReferenceBuilder toBuilder();
	
	static PaymentReference.PaymentReferenceBuilder builder() {
		return new PaymentReference.PaymentReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentReference> getType() {
		return PaymentReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentReferenceBuilder extends PaymentReference, Reference.ReferenceBuilder {
		PaymentReference.PaymentReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PaymentReference.PaymentReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentReference  ***********************/
	class PaymentReferenceImpl extends Reference.ReferenceImpl implements PaymentReference {
		private final String href;
		
		protected PaymentReferenceImpl(PaymentReference.PaymentReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PaymentReference build() {
			return this;
		}
		
		@Override
		public PaymentReference.PaymentReferenceBuilder toBuilder() {
			PaymentReference.PaymentReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentReference.PaymentReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PaymentReference  ***********************/
	class PaymentReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PaymentReference.PaymentReferenceBuilder {
	
		protected String href;
	
		public PaymentReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PaymentReference.PaymentReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PaymentReference build() {
			return new PaymentReference.PaymentReferenceImpl(this);
		}
		
		@Override
		public PaymentReference.PaymentReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentReference.PaymentReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentReference.PaymentReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PaymentReference.PaymentReferenceBuilder o = (PaymentReference.PaymentReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}

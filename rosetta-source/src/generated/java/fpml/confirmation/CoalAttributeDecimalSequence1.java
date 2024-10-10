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
import fpml.confirmation.CoalAttributeDecimalSequence1;
import fpml.confirmation.CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder;
import fpml.confirmation.CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1BuilderImpl;
import fpml.confirmation.CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Impl;
import fpml.confirmation.meta.CoalAttributeDecimalSequence1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CoalAttributeDecimalSequence1", builder=CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1BuilderImpl.class, version="${project.version}")
public interface CoalAttributeDecimalSequence1 extends RosettaModelObject {

	CoalAttributeDecimalSequence1Meta metaData = new CoalAttributeDecimalSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment.
	 */
	BigDecimal getRejectionLimit();

	/*********************** Build Methods  ***********************/
	CoalAttributeDecimalSequence1 build();
	
	CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder toBuilder();
	
	static CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder builder() {
		return new CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributeDecimalSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributeDecimalSequence1> getType() {
		return CoalAttributeDecimalSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributeDecimalSequence1Builder extends CoalAttributeDecimalSequence1, RosettaModelObjectBuilder {
		CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder prune();
	}

	/*********************** Immutable Implementation of CoalAttributeDecimalSequence1  ***********************/
	class CoalAttributeDecimalSequence1Impl implements CoalAttributeDecimalSequence1 {
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributeDecimalSequence1Impl(CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder builder) {
			this.rejectionLimit = builder.getRejectionLimit();
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		public CoalAttributeDecimalSequence1 build() {
			return this;
		}
		
		@Override
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder toBuilder() {
			CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder builder) {
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimalSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributeDecimalSequence1 {" +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributeDecimalSequence1  ***********************/
	class CoalAttributeDecimalSequence1BuilderImpl implements CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder {
	
		protected BigDecimal rejectionLimit;
	
		public CoalAttributeDecimalSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder setRejectionLimit(BigDecimal rejectionLimit) {
			this.rejectionLimit = rejectionLimit==null?null:rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributeDecimalSequence1 build() {
			return new CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Impl(this);
		}
		
		@Override
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRejectionLimit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder o = (CoalAttributeDecimalSequence1.CoalAttributeDecimalSequence1Builder) other;
			
			
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimalSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributeDecimalSequence1Builder {" +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}

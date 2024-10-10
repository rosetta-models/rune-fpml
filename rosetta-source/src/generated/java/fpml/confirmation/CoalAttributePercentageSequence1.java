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
import fpml.confirmation.CoalAttributePercentageSequence1;
import fpml.confirmation.CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder;
import fpml.confirmation.CoalAttributePercentageSequence1.CoalAttributePercentageSequence1BuilderImpl;
import fpml.confirmation.CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Impl;
import fpml.confirmation.meta.CoalAttributePercentageSequence1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CoalAttributePercentageSequence1", builder=CoalAttributePercentageSequence1.CoalAttributePercentageSequence1BuilderImpl.class, version="${project.version}")
public interface CoalAttributePercentageSequence1 extends RosettaModelObject {

	CoalAttributePercentageSequence1Meta metaData = new CoalAttributePercentageSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment.
	 */
	BigDecimal getRejectionLimit();

	/*********************** Build Methods  ***********************/
	CoalAttributePercentageSequence1 build();
	
	CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder toBuilder();
	
	static CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder builder() {
		return new CoalAttributePercentageSequence1.CoalAttributePercentageSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributePercentageSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributePercentageSequence1> getType() {
		return CoalAttributePercentageSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributePercentageSequence1Builder extends CoalAttributePercentageSequence1, RosettaModelObjectBuilder {
		CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder prune();
	}

	/*********************** Immutable Implementation of CoalAttributePercentageSequence1  ***********************/
	class CoalAttributePercentageSequence1Impl implements CoalAttributePercentageSequence1 {
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributePercentageSequence1Impl(CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder builder) {
			this.rejectionLimit = builder.getRejectionLimit();
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		public CoalAttributePercentageSequence1 build() {
			return this;
		}
		
		@Override
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder toBuilder() {
			CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder builder) {
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentageSequence1 _that = getType().cast(o);
		
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
			return "CoalAttributePercentageSequence1 {" +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributePercentageSequence1  ***********************/
	class CoalAttributePercentageSequence1BuilderImpl implements CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder {
	
		protected BigDecimal rejectionLimit;
	
		public CoalAttributePercentageSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder setRejectionLimit(BigDecimal rejectionLimit) {
			this.rejectionLimit = rejectionLimit==null?null:rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributePercentageSequence1 build() {
			return new CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Impl(this);
		}
		
		@Override
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRejectionLimit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder o = (CoalAttributePercentageSequence1.CoalAttributePercentageSequence1Builder) other;
			
			
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentageSequence1 _that = getType().cast(o);
		
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
			return "CoalAttributePercentageSequence1Builder {" +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}

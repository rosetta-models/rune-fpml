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
import fpml.confirmation.CoalAttributePercentageSequence0;
import fpml.confirmation.CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder;
import fpml.confirmation.CoalAttributePercentageSequence0.CoalAttributePercentageSequence0BuilderImpl;
import fpml.confirmation.CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Impl;
import fpml.confirmation.meta.CoalAttributePercentageSequence0Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalAttributePercentageSequence0", builder=CoalAttributePercentageSequence0.CoalAttributePercentageSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalAttributePercentageSequence0 extends RosettaModelObject {

	CoalAttributePercentageSequence0Meta metaData = new CoalAttributePercentageSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The actual content of the quality characteristics of the Coal Product Shipment expected by the Buyer.
	 */
	BigDecimal getStandardContent();
	/**
	 * The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment.
	 */
	BigDecimal getRejectionLimit();

	/*********************** Build Methods  ***********************/
	CoalAttributePercentageSequence0 build();
	
	CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder toBuilder();
	
	static CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder builder() {
		return new CoalAttributePercentageSequence0.CoalAttributePercentageSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributePercentageSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributePercentageSequence0> getType() {
		return CoalAttributePercentageSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributePercentageSequence0Builder extends CoalAttributePercentageSequence0, RosettaModelObjectBuilder {
		CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder setStandardContent(BigDecimal standardContent);
		CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder prune();
	}

	/*********************** Immutable Implementation of CoalAttributePercentageSequence0  ***********************/
	class CoalAttributePercentageSequence0Impl implements CoalAttributePercentageSequence0 {
		private final BigDecimal standardContent;
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributePercentageSequence0Impl(CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder builder) {
			this.standardContent = builder.getStandardContent();
			this.rejectionLimit = builder.getRejectionLimit();
		}
		
		@Override
		@RosettaAttribute("standardContent")
		public BigDecimal getStandardContent() {
			return standardContent;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		public CoalAttributePercentageSequence0 build() {
			return this;
		}
		
		@Override
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder toBuilder() {
			CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder builder) {
			ofNullable(getStandardContent()).ifPresent(builder::setStandardContent);
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentageSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(standardContent, _that.getStandardContent())) return false;
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardContent != null ? standardContent.hashCode() : 0);
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentageSequence0 {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributePercentageSequence0  ***********************/
	class CoalAttributePercentageSequence0BuilderImpl implements CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder {
	
		protected BigDecimal standardContent;
		protected BigDecimal rejectionLimit;
	
		public CoalAttributePercentageSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("standardContent")
		public BigDecimal getStandardContent() {
			return standardContent;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		@RosettaAttribute("standardContent")
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder setStandardContent(BigDecimal standardContent) {
			this.standardContent = standardContent==null?null:standardContent;
			return this;
		}
		@Override
		@RosettaAttribute("rejectionLimit")
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder setRejectionLimit(BigDecimal rejectionLimit) {
			this.rejectionLimit = rejectionLimit==null?null:rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributePercentageSequence0 build() {
			return new CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Impl(this);
		}
		
		@Override
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardContent()!=null) return true;
			if (getRejectionLimit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder o = (CoalAttributePercentageSequence0.CoalAttributePercentageSequence0Builder) other;
			
			
			merger.mergeBasic(getStandardContent(), o.getStandardContent(), this::setStandardContent);
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentageSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(standardContent, _that.getStandardContent())) return false;
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardContent != null ? standardContent.hashCode() : 0);
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentageSequence0Builder {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}

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
import fpml.confirmation.CoalAttributeDecimalSequence0;
import fpml.confirmation.CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder;
import fpml.confirmation.CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0BuilderImpl;
import fpml.confirmation.CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Impl;
import fpml.confirmation.meta.CoalAttributeDecimalSequence0Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CoalAttributeDecimalSequence0", builder=CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0BuilderImpl.class, version="${project.version}")
public interface CoalAttributeDecimalSequence0 extends RosettaModelObject {

	CoalAttributeDecimalSequence0Meta metaData = new CoalAttributeDecimalSequence0Meta();

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
	CoalAttributeDecimalSequence0 build();
	
	CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder toBuilder();
	
	static CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder builder() {
		return new CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributeDecimalSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalAttributeDecimalSequence0> getType() {
		return CoalAttributeDecimalSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributeDecimalSequence0Builder extends CoalAttributeDecimalSequence0, RosettaModelObjectBuilder {
		CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder setStandardContent(BigDecimal standardContent);
		CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder prune();
	}

	/*********************** Immutable Implementation of CoalAttributeDecimalSequence0  ***********************/
	class CoalAttributeDecimalSequence0Impl implements CoalAttributeDecimalSequence0 {
		private final BigDecimal standardContent;
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributeDecimalSequence0Impl(CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder builder) {
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
		public CoalAttributeDecimalSequence0 build() {
			return this;
		}
		
		@Override
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder toBuilder() {
			CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder builder) {
			ofNullable(getStandardContent()).ifPresent(builder::setStandardContent);
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimalSequence0 _that = getType().cast(o);
		
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
			return "CoalAttributeDecimalSequence0 {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributeDecimalSequence0  ***********************/
	class CoalAttributeDecimalSequence0BuilderImpl implements CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder {
	
		protected BigDecimal standardContent;
		protected BigDecimal rejectionLimit;
	
		public CoalAttributeDecimalSequence0BuilderImpl() {
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
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder setStandardContent(BigDecimal standardContent) {
			this.standardContent = standardContent==null?null:standardContent;
			return this;
		}
		@Override
		@RosettaAttribute("rejectionLimit")
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder setRejectionLimit(BigDecimal rejectionLimit) {
			this.rejectionLimit = rejectionLimit==null?null:rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributeDecimalSequence0 build() {
			return new CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Impl(this);
		}
		
		@Override
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder prune() {
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
		public CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder o = (CoalAttributeDecimalSequence0.CoalAttributeDecimalSequence0Builder) other;
			
			
			merger.mergeBasic(getStandardContent(), o.getStandardContent(), this::setStandardContent);
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimalSequence0 _that = getType().cast(o);
		
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
			return "CoalAttributeDecimalSequence0Builder {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}

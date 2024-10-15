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
import fpml.confirmation.TradeNotionalChangeModelSequence1;
import fpml.confirmation.TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder;
import fpml.confirmation.TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1BuilderImpl;
import fpml.confirmation.TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Impl;
import fpml.confirmation.meta.TradeNotionalChangeModelSequence1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNotionalChangeModelSequence1", builder=TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1BuilderImpl.class, version="${project.version}")
public interface TradeNotionalChangeModelSequence1 extends RosettaModelObject {

	TradeNotionalChangeModelSequence1Meta metaData = new TradeNotionalChangeModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fixed amount by which the Number of Options changes
	 */
	BigDecimal getChangeInNumberOfOptions();
	/**
	 * Specifies the Number of Options after the Change.
	 */
	BigDecimal getOutstandingNumberOfOptions();

	/*********************** Build Methods  ***********************/
	TradeNotionalChangeModelSequence1 build();
	
	TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder toBuilder();
	
	static TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder builder() {
		return new TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChangeModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNotionalChangeModelSequence1> getType() {
		return TradeNotionalChangeModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeModelSequence1Builder extends TradeNotionalChangeModelSequence1, RosettaModelObjectBuilder {
		TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions);
		TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		}
		

		TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChangeModelSequence1  ***********************/
	class TradeNotionalChangeModelSequence1Impl implements TradeNotionalChangeModelSequence1 {
		private final BigDecimal changeInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		
		protected TradeNotionalChangeModelSequence1Impl(TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder builder) {
			this.changeInNumberOfOptions = builder.getChangeInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		public TradeNotionalChangeModelSequence1 build() {
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder toBuilder() {
			TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder builder) {
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence1 {" +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNotionalChangeModelSequence1  ***********************/
	class TradeNotionalChangeModelSequence1BuilderImpl implements TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder {
	
		protected BigDecimal changeInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
	
		public TradeNotionalChangeModelSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions) {
			this.changeInNumberOfOptions = changeInNumberOfOptions==null?null:changeInNumberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = outstandingNumberOfOptions==null?null:outstandingNumberOfOptions;
			return this;
		}
		
		@Override
		public TradeNotionalChangeModelSequence1 build() {
			return new TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Impl(this);
		}
		
		@Override
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder o = (TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder) other;
			
			
			merger.mergeBasic(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::setChangeInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelSequence1Builder {" +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}
}

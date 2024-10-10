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
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.DiscountRateModel;
import fpml.confirmation.DiscountRateModel.DiscountRateModelBuilder;
import fpml.confirmation.DiscountRateModel.DiscountRateModelBuilderImpl;
import fpml.confirmation.DiscountRateModel.DiscountRateModelImpl;
import fpml.confirmation.meta.DiscountRateModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Model group enforces association of day count fraction with the discount rate.
 * @version ${project.version}
 */
@RosettaDataType(value="DiscountRateModel", builder=DiscountRateModel.DiscountRateModelBuilderImpl.class, version="${project.version}")
public interface DiscountRateModel extends RosettaModelObject {

	DiscountRateModelMeta metaData = new DiscountRateModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
	 */
	BigDecimal getDiscountRate();
	/**
	 * A discount day count fraction to be used in the calculation of a discounted amount.
	 */
	DayCountFraction getDiscountRateDayCountFraction();

	/*********************** Build Methods  ***********************/
	DiscountRateModel build();
	
	DiscountRateModel.DiscountRateModelBuilder toBuilder();
	
	static DiscountRateModel.DiscountRateModelBuilder builder() {
		return new DiscountRateModel.DiscountRateModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DiscountRateModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DiscountRateModel> getType() {
		return DiscountRateModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
		processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, DayCountFraction.class, getDiscountRateDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DiscountRateModelBuilder extends DiscountRateModel, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDiscountRateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDiscountRateDayCountFraction();
		DiscountRateModel.DiscountRateModelBuilder setDiscountRate(BigDecimal discountRate);
		DiscountRateModel.DiscountRateModelBuilder setDiscountRateDayCountFraction(DayCountFraction discountRateDayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
			processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDiscountRateDayCountFraction());
		}
		

		DiscountRateModel.DiscountRateModelBuilder prune();
	}

	/*********************** Immutable Implementation of DiscountRateModel  ***********************/
	class DiscountRateModelImpl implements DiscountRateModel {
		private final BigDecimal discountRate;
		private final DayCountFraction discountRateDayCountFraction;
		
		protected DiscountRateModelImpl(DiscountRateModel.DiscountRateModelBuilder builder) {
			this.discountRate = builder.getDiscountRate();
			this.discountRateDayCountFraction = ofNullable(builder.getDiscountRateDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("discountRate")
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		@RosettaAttribute("discountRateDayCountFraction")
		public DayCountFraction getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public DiscountRateModel build() {
			return this;
		}
		
		@Override
		public DiscountRateModel.DiscountRateModelBuilder toBuilder() {
			DiscountRateModel.DiscountRateModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DiscountRateModel.DiscountRateModelBuilder builder) {
			ofNullable(getDiscountRate()).ifPresent(builder::setDiscountRate);
			ofNullable(getDiscountRateDayCountFraction()).ifPresent(builder::setDiscountRateDayCountFraction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DiscountRateModel _that = getType().cast(o);
		
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountRateModel {" +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of DiscountRateModel  ***********************/
	class DiscountRateModelBuilderImpl implements DiscountRateModel.DiscountRateModelBuilder {
	
		protected BigDecimal discountRate;
		protected DayCountFraction.DayCountFractionBuilder discountRateDayCountFraction;
	
		public DiscountRateModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("discountRate")
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		@RosettaAttribute("discountRateDayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDiscountRateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (discountRateDayCountFraction!=null) {
				result = discountRateDayCountFraction;
			}
			else {
				result = discountRateDayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("discountRate")
		public DiscountRateModel.DiscountRateModelBuilder setDiscountRate(BigDecimal discountRate) {
			this.discountRate = discountRate==null?null:discountRate;
			return this;
		}
		@Override
		@RosettaAttribute("discountRateDayCountFraction")
		public DiscountRateModel.DiscountRateModelBuilder setDiscountRateDayCountFraction(DayCountFraction discountRateDayCountFraction) {
			this.discountRateDayCountFraction = discountRateDayCountFraction==null?null:discountRateDayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public DiscountRateModel build() {
			return new DiscountRateModel.DiscountRateModelImpl(this);
		}
		
		@Override
		public DiscountRateModel.DiscountRateModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DiscountRateModel.DiscountRateModelBuilder prune() {
			if (discountRateDayCountFraction!=null && !discountRateDayCountFraction.prune().hasData()) discountRateDayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDiscountRate()!=null) return true;
			if (getDiscountRateDayCountFraction()!=null && getDiscountRateDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DiscountRateModel.DiscountRateModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DiscountRateModel.DiscountRateModelBuilder o = (DiscountRateModel.DiscountRateModelBuilder) other;
			
			merger.mergeRosetta(getDiscountRateDayCountFraction(), o.getDiscountRateDayCountFraction(), this::setDiscountRateDayCountFraction);
			
			merger.mergeBasic(getDiscountRate(), o.getDiscountRate(), this::setDiscountRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DiscountRateModel _that = getType().cast(o);
		
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountRateModelBuilder {" +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction +
			'}';
		}
	}
}

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
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.MakeWholeAmount;
import fpml.confirmation.MakeWholeAmount.MakeWholeAmountBuilder;
import fpml.confirmation.MakeWholeAmount.MakeWholeAmountBuilderImpl;
import fpml.confirmation.MakeWholeAmount.MakeWholeAmountImpl;
import fpml.confirmation.QuotationSideEnum;
import fpml.confirmation.SwapCurveValuation;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationBuilder;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationBuilderImpl;
import fpml.confirmation.SwapCurveValuation.SwapCurveValuationImpl;
import fpml.confirmation.meta.MakeWholeAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A complex type to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (Typically applicable to the convertible bond options).
 * @version ${project.version}
 */
@RosettaDataType(value="MakeWholeAmount", builder=MakeWholeAmount.MakeWholeAmountBuilderImpl.class, version="${project.version}")
public interface MakeWholeAmount extends SwapCurveValuation {

	MakeWholeAmountMeta metaData = new MakeWholeAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of interpolation method that the calculation agent reserves the right to use.
	 */
	InterpolationMethod getInterpolationMethod();
	/**
	 * Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
	 */
	IdentifiedDate getEarlyCallDate();

	/*********************** Build Methods  ***********************/
	MakeWholeAmount build();
	
	MakeWholeAmount.MakeWholeAmountBuilder toBuilder();
	
	static MakeWholeAmount.MakeWholeAmountBuilder builder() {
		return new MakeWholeAmount.MakeWholeAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MakeWholeAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MakeWholeAmount> getType() {
		return MakeWholeAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.class, getFloatingRateIndexModel());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processRosetta(path.newSubPath("earlyCallDate"), processor, IdentifiedDate.class, getEarlyCallDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MakeWholeAmountBuilder extends MakeWholeAmount, SwapCurveValuation.SwapCurveValuationBuilder {
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEarlyCallDate();
		IdentifiedDate.IdentifiedDateBuilder getEarlyCallDate();
		MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal spread);
		MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum side);
		MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(IdentifiedDate earlyCallDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processRosetta(path.newSubPath("earlyCallDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEarlyCallDate());
		}
		

		MakeWholeAmount.MakeWholeAmountBuilder prune();
	}

	/*********************** Immutable Implementation of MakeWholeAmount  ***********************/
	class MakeWholeAmountImpl extends SwapCurveValuation.SwapCurveValuationImpl implements MakeWholeAmount {
		private final InterpolationMethod interpolationMethod;
		private final IdentifiedDate earlyCallDate;
		
		protected MakeWholeAmountImpl(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super(builder);
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.earlyCallDate = ofNullable(builder.getEarlyCallDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("earlyCallDate")
		public IdentifiedDate getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public MakeWholeAmount build() {
			return this;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			MakeWholeAmount.MakeWholeAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getEarlyCallDate()).ifPresent(builder::setEarlyCallDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmount {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"earlyCallDate=" + this.earlyCallDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MakeWholeAmount  ***********************/
	class MakeWholeAmountBuilderImpl extends SwapCurveValuation.SwapCurveValuationBuilderImpl  implements MakeWholeAmount.MakeWholeAmountBuilder {
	
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected IdentifiedDate.IdentifiedDateBuilder earlyCallDate;
	
		public MakeWholeAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earlyCallDate")
		public IdentifiedDate.IdentifiedDateBuilder getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEarlyCallDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (earlyCallDate!=null) {
				result = earlyCallDate;
			}
			else {
				result = earlyCallDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		@Override
		@RosettaAttribute("side")
		public MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum side) {
			this.side = side==null?null:side;
			return this;
		}
		@Override
		@RosettaAttribute("interpolationMethod")
		public MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethod interpolationMethod) {
			this.interpolationMethod = interpolationMethod==null?null:interpolationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("earlyCallDate")
		public MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(IdentifiedDate earlyCallDate) {
			this.earlyCallDate = earlyCallDate==null?null:earlyCallDate.toBuilder();
			return this;
		}
		
		@Override
		public MakeWholeAmount build() {
			return new MakeWholeAmount.MakeWholeAmountImpl(this);
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder prune() {
			super.prune();
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			if (earlyCallDate!=null && !earlyCallDate.prune().hasData()) earlyCallDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getEarlyCallDate()!=null && getEarlyCallDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MakeWholeAmount.MakeWholeAmountBuilder o = (MakeWholeAmount.MakeWholeAmountBuilder) other;
			
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			merger.mergeRosetta(getEarlyCallDate(), o.getEarlyCallDate(), this::setEarlyCallDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmountBuilder {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"earlyCallDate=" + this.earlyCallDate +
			'}' + " " + super.toString();
		}
	}
}

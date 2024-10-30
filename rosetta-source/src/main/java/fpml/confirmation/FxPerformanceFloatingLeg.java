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
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder;
import fpml.confirmation.FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl;
import fpml.confirmation.FxPerformanceFloatingLeg.FxPerformanceFloatingLegImpl;
import fpml.confirmation.FxPerformanceLeg;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilder;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegBuilderImpl;
import fpml.confirmation.FxPerformanceLeg.FxPerformanceLegImpl;
import fpml.confirmation.PayerModel;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.meta.FxPerformanceFloatingLegMeta;


/**
 * Fx Performance Floating Leg describes Floating FX Rate Payer.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxPerformanceFloatingLeg", builder=FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxPerformanceFloatingLeg extends FxPerformanceLeg {

	FxPerformanceFloatingLegMeta metaData = new FxPerformanceFloatingLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxPerformanceFloatingLeg build();
	
	FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder();
	
	static FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder() {
		return new FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceFloatingLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxPerformanceFloatingLeg> getType() {
		return FxPerformanceFloatingLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerModel"), processor, PayerModel.class, getPayerModel());
		processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.class, getReceiverModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceFloatingLegBuilder extends FxPerformanceFloatingLeg, FxPerformanceLeg.FxPerformanceLegBuilder {
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerModel(PayerModel payerModel);
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverModel(ReceiverModel receiverModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerModel"), processor, PayerModel.PayerModelBuilder.class, getPayerModel());
			processRosetta(path.newSubPath("receiverModel"), processor, ReceiverModel.ReceiverModelBuilder.class, getReceiverModel());
		}
		

		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceFloatingLeg  ***********************/
	class FxPerformanceFloatingLegImpl extends FxPerformanceLeg.FxPerformanceLegImpl implements FxPerformanceFloatingLeg {
		
		protected FxPerformanceFloatingLegImpl(FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxPerformanceFloatingLeg build() {
			return this;
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder() {
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFloatingLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceFloatingLeg  ***********************/
	class FxPerformanceFloatingLegBuilderImpl extends FxPerformanceLeg.FxPerformanceLegBuilderImpl  implements FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder {
	
	
		public FxPerformanceFloatingLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerModel")
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerModel(PayerModel payerModel) {
			this.payerModel = payerModel==null?null:payerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("receiverModel")
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverModel(ReceiverModel receiverModel) {
			this.receiverModel = receiverModel==null?null:receiverModel.toBuilder();
			return this;
		}
		
		@Override
		public FxPerformanceFloatingLeg build() {
			return new FxPerformanceFloatingLeg.FxPerformanceFloatingLegImpl(this);
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder o = (FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFloatingLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

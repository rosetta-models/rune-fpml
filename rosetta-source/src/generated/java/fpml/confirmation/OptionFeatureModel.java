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
import fpml.confirmation.Asian;
import fpml.confirmation.Barrier;
import fpml.confirmation.Knock;
import fpml.confirmation.OptionFeatureModel;
import fpml.confirmation.OptionFeatureModel.OptionFeatureModelBuilder;
import fpml.confirmation.OptionFeatureModel.OptionFeatureModelBuilderImpl;
import fpml.confirmation.OptionFeatureModel.OptionFeatureModelImpl;
import fpml.confirmation.PassThrough;
import fpml.confirmation.meta.OptionFeatureModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group containing Option Base Feature Elements.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionFeatureModel", builder=OptionFeatureModel.OptionFeatureModelBuilderImpl.class, version="${project.version}")
public interface OptionFeatureModel extends RosettaModelObject {

	OptionFeatureModelMeta metaData = new OptionFeatureModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An option where and average price is taken on valuation.
	 */
	Asian getAsian();
	/**
	 * An option with a barrier feature.
	 */
	Barrier getBarrier();
	/**
	 * A knock feature.
	 */
	Knock getKnock();
	/**
	 * Pass through payments from the underlyer, such as dividends.
	 */
	PassThrough getPassThrough();

	/*********************** Build Methods  ***********************/
	OptionFeatureModel build();
	
	OptionFeatureModel.OptionFeatureModelBuilder toBuilder();
	
	static OptionFeatureModel.OptionFeatureModelBuilder builder() {
		return new OptionFeatureModel.OptionFeatureModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionFeatureModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionFeatureModel> getType() {
		return OptionFeatureModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("asian"), processor, Asian.class, getAsian());
		processRosetta(path.newSubPath("barrier"), processor, Barrier.class, getBarrier());
		processRosetta(path.newSubPath("knock"), processor, Knock.class, getKnock());
		processRosetta(path.newSubPath("passThrough"), processor, PassThrough.class, getPassThrough());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionFeatureModelBuilder extends OptionFeatureModel, RosettaModelObjectBuilder {
		Asian.AsianBuilder getOrCreateAsian();
		Asian.AsianBuilder getAsian();
		Barrier.BarrierBuilder getOrCreateBarrier();
		Barrier.BarrierBuilder getBarrier();
		Knock.KnockBuilder getOrCreateKnock();
		Knock.KnockBuilder getKnock();
		PassThrough.PassThroughBuilder getOrCreatePassThrough();
		PassThrough.PassThroughBuilder getPassThrough();
		OptionFeatureModel.OptionFeatureModelBuilder setAsian(Asian asian);
		OptionFeatureModel.OptionFeatureModelBuilder setBarrier(Barrier barrier);
		OptionFeatureModel.OptionFeatureModelBuilder setKnock(Knock knock);
		OptionFeatureModel.OptionFeatureModelBuilder setPassThrough(PassThrough passThrough);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("asian"), processor, Asian.AsianBuilder.class, getAsian());
			processRosetta(path.newSubPath("barrier"), processor, Barrier.BarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("knock"), processor, Knock.KnockBuilder.class, getKnock());
			processRosetta(path.newSubPath("passThrough"), processor, PassThrough.PassThroughBuilder.class, getPassThrough());
		}
		

		OptionFeatureModel.OptionFeatureModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionFeatureModel  ***********************/
	class OptionFeatureModelImpl implements OptionFeatureModel {
		private final Asian asian;
		private final Barrier barrier;
		private final Knock knock;
		private final PassThrough passThrough;
		
		protected OptionFeatureModelImpl(OptionFeatureModel.OptionFeatureModelBuilder builder) {
			this.asian = ofNullable(builder.getAsian()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.knock = ofNullable(builder.getKnock()).map(f->f.build()).orElse(null);
			this.passThrough = ofNullable(builder.getPassThrough()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("asian")
		public Asian getAsian() {
			return asian;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public Barrier getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("knock")
		public Knock getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("passThrough")
		public PassThrough getPassThrough() {
			return passThrough;
		}
		
		@Override
		public OptionFeatureModel build() {
			return this;
		}
		
		@Override
		public OptionFeatureModel.OptionFeatureModelBuilder toBuilder() {
			OptionFeatureModel.OptionFeatureModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionFeatureModel.OptionFeatureModelBuilder builder) {
			ofNullable(getAsian()).ifPresent(builder::setAsian);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getPassThrough()).ifPresent(builder::setPassThrough);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatureModel {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionFeatureModel  ***********************/
	class OptionFeatureModelBuilderImpl implements OptionFeatureModel.OptionFeatureModelBuilder {
	
		protected Asian.AsianBuilder asian;
		protected Barrier.BarrierBuilder barrier;
		protected Knock.KnockBuilder knock;
		protected PassThrough.PassThroughBuilder passThrough;
	
		public OptionFeatureModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("asian")
		public Asian.AsianBuilder getAsian() {
			return asian;
		}
		
		@Override
		public Asian.AsianBuilder getOrCreateAsian() {
			Asian.AsianBuilder result;
			if (asian!=null) {
				result = asian;
			}
			else {
				result = asian = Asian.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public Barrier.BarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public Barrier.BarrierBuilder getOrCreateBarrier() {
			Barrier.BarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = Barrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knock")
		public Knock.KnockBuilder getKnock() {
			return knock;
		}
		
		@Override
		public Knock.KnockBuilder getOrCreateKnock() {
			Knock.KnockBuilder result;
			if (knock!=null) {
				result = knock;
			}
			else {
				result = knock = Knock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("passThrough")
		public PassThrough.PassThroughBuilder getPassThrough() {
			return passThrough;
		}
		
		@Override
		public PassThrough.PassThroughBuilder getOrCreatePassThrough() {
			PassThrough.PassThroughBuilder result;
			if (passThrough!=null) {
				result = passThrough;
			}
			else {
				result = passThrough = PassThrough.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asian")
		public OptionFeatureModel.OptionFeatureModelBuilder setAsian(Asian asian) {
			this.asian = asian==null?null:asian.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public OptionFeatureModel.OptionFeatureModelBuilder setBarrier(Barrier barrier) {
			this.barrier = barrier==null?null:barrier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("knock")
		public OptionFeatureModel.OptionFeatureModelBuilder setKnock(Knock knock) {
			this.knock = knock==null?null:knock.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("passThrough")
		public OptionFeatureModel.OptionFeatureModelBuilder setPassThrough(PassThrough passThrough) {
			this.passThrough = passThrough==null?null:passThrough.toBuilder();
			return this;
		}
		
		@Override
		public OptionFeatureModel build() {
			return new OptionFeatureModel.OptionFeatureModelImpl(this);
		}
		
		@Override
		public OptionFeatureModel.OptionFeatureModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeatureModel.OptionFeatureModelBuilder prune() {
			if (asian!=null && !asian.prune().hasData()) asian = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (knock!=null && !knock.prune().hasData()) knock = null;
			if (passThrough!=null && !passThrough.prune().hasData()) passThrough = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsian()!=null && getAsian().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getKnock()!=null && getKnock().hasData()) return true;
			if (getPassThrough()!=null && getPassThrough().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeatureModel.OptionFeatureModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionFeatureModel.OptionFeatureModelBuilder o = (OptionFeatureModel.OptionFeatureModelBuilder) other;
			
			merger.mergeRosetta(getAsian(), o.getAsian(), this::setAsian);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getKnock(), o.getKnock(), this::setKnock);
			merger.mergeRosetta(getPassThrough(), o.getPassThrough(), this::setPassThrough);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatureModelBuilder {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough +
			'}';
		}
	}
}

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
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilderImpl;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelImpl;
import fpml.confirmation.meta.TradeLegNotionalScheduleChangeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeLegNotionalScheduleChangeModel", builder=TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilderImpl.class, version="${project.version}")
public interface TradeLegNotionalScheduleChangeModel extends RosettaModelObject {

	TradeLegNotionalScheduleChangeModelMeta metaData = new TradeLegNotionalScheduleChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	NotionalReference getNotionalScheduleReference();
	NonNegativeAmountSchedule getChangeInNotionalSchedule();
	NonNegativeAmountSchedule getOutstandingNotionalSchedule();

	/*********************** Build Methods  ***********************/
	TradeLegNotionalScheduleChangeModel build();
	
	TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder toBuilder();
	
	static TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder builder() {
		return new TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegNotionalScheduleChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegNotionalScheduleChangeModel> getType() {
		return TradeLegNotionalScheduleChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.class, getNotionalScheduleReference());
		processRosetta(path.newSubPath("changeInNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getChangeInNotionalSchedule());
		processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getOutstandingNotionalSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegNotionalScheduleChangeModelBuilder extends TradeLegNotionalScheduleChangeModel, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference();
		NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateChangeInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getChangeInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule();
		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setNotionalScheduleReference(NotionalReference notionalScheduleReference);
		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setChangeInNotionalSchedule(NonNegativeAmountSchedule changeInNotionalSchedule);
		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalScheduleReference());
			processRosetta(path.newSubPath("changeInNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getChangeInNotionalSchedule());
			processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getOutstandingNotionalSchedule());
		}
		

		TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegNotionalScheduleChangeModel  ***********************/
	class TradeLegNotionalScheduleChangeModelImpl implements TradeLegNotionalScheduleChangeModel {
		private final NotionalReference notionalScheduleReference;
		private final NonNegativeAmountSchedule changeInNotionalSchedule;
		private final NonNegativeAmountSchedule outstandingNotionalSchedule;
		
		protected TradeLegNotionalScheduleChangeModelImpl(TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder builder) {
			this.notionalScheduleReference = ofNullable(builder.getNotionalScheduleReference()).map(f->f.build()).orElse(null);
			this.changeInNotionalSchedule = ofNullable(builder.getChangeInNotionalSchedule()).map(f->f.build()).orElse(null);
			this.outstandingNotionalSchedule = ofNullable(builder.getOutstandingNotionalSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public NotionalReference getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalSchedule")
		public NonNegativeAmountSchedule getChangeInNotionalSchedule() {
			return changeInNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		public TradeLegNotionalScheduleChangeModel build() {
			return this;
		}
		
		@Override
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder toBuilder() {
			TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder builder) {
			ofNullable(getNotionalScheduleReference()).ifPresent(builder::setNotionalScheduleReference);
			ofNullable(getChangeInNotionalSchedule()).ifPresent(builder::setChangeInNotionalSchedule);
			ofNullable(getOutstandingNotionalSchedule()).ifPresent(builder::setOutstandingNotionalSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNotionalScheduleChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(changeInNotionalSchedule, _that.getChangeInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalSchedule != null ? changeInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNotionalScheduleChangeModel {" +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"changeInNotionalSchedule=" + this.changeInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegNotionalScheduleChangeModel  ***********************/
	class TradeLegNotionalScheduleChangeModelBuilderImpl implements TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalScheduleReference;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder changeInNotionalSchedule;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder outstandingNotionalSchedule;
	
		public TradeLegNotionalScheduleChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalScheduleReference!=null) {
				result = notionalScheduleReference;
			}
			else {
				result = notionalScheduleReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getChangeInNotionalSchedule() {
			return changeInNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateChangeInNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (changeInNotionalSchedule!=null) {
				result = changeInNotionalSchedule;
			}
			else {
				result = changeInNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (outstandingNotionalSchedule!=null) {
				result = outstandingNotionalSchedule;
			}
			else {
				result = outstandingNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setNotionalScheduleReference(NotionalReference notionalScheduleReference) {
			this.notionalScheduleReference = notionalScheduleReference==null?null:notionalScheduleReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeInNotionalSchedule")
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setChangeInNotionalSchedule(NonNegativeAmountSchedule changeInNotionalSchedule) {
			this.changeInNotionalSchedule = changeInNotionalSchedule==null?null:changeInNotionalSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule) {
			this.outstandingNotionalSchedule = outstandingNotionalSchedule==null?null:outstandingNotionalSchedule.toBuilder();
			return this;
		}
		
		@Override
		public TradeLegNotionalScheduleChangeModel build() {
			return new TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelImpl(this);
		}
		
		@Override
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder prune() {
			if (notionalScheduleReference!=null && !notionalScheduleReference.prune().hasData()) notionalScheduleReference = null;
			if (changeInNotionalSchedule!=null && !changeInNotionalSchedule.prune().hasData()) changeInNotionalSchedule = null;
			if (outstandingNotionalSchedule!=null && !outstandingNotionalSchedule.prune().hasData()) outstandingNotionalSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalScheduleReference()!=null && getNotionalScheduleReference().hasData()) return true;
			if (getChangeInNotionalSchedule()!=null && getChangeInNotionalSchedule().hasData()) return true;
			if (getOutstandingNotionalSchedule()!=null && getOutstandingNotionalSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder o = (TradeLegNotionalScheduleChangeModel.TradeLegNotionalScheduleChangeModelBuilder) other;
			
			merger.mergeRosetta(getNotionalScheduleReference(), o.getNotionalScheduleReference(), this::setNotionalScheduleReference);
			merger.mergeRosetta(getChangeInNotionalSchedule(), o.getChangeInNotionalSchedule(), this::setChangeInNotionalSchedule);
			merger.mergeRosetta(getOutstandingNotionalSchedule(), o.getOutstandingNotionalSchedule(), this::setOutstandingNotionalSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNotionalScheduleChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(changeInNotionalSchedule, _that.getChangeInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalSchedule != null ? changeInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNotionalScheduleChangeModelBuilder {" +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"changeInNotionalSchedule=" + this.changeInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule +
			'}';
		}
	}
}

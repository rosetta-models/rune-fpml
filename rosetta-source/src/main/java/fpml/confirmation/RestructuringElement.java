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
import fpml.confirmation.Money;
import fpml.confirmation.RestructuringElement;
import fpml.confirmation.RestructuringElement.RestructuringElementBuilder;
import fpml.confirmation.RestructuringElement.RestructuringElementBuilderImpl;
import fpml.confirmation.RestructuringElement.RestructuringElementImpl;
import fpml.confirmation.RestructuringEvent;
import fpml.confirmation.RestructuringEvent.RestructuringEventBuilder;
import fpml.confirmation.RestructuringEvent.RestructuringEventBuilderImpl;
import fpml.confirmation.RestructuringEvent.RestructuringEventImpl;
import fpml.confirmation.meta.RestructuringElementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="RestructuringElement", builder=RestructuringElement.RestructuringElementBuilderImpl.class, version="${project.version}")
public interface RestructuringElement extends RestructuringEvent {

	RestructuringElementMeta metaData = new RestructuringElementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RestructuringElement build();
	
	RestructuringElement.RestructuringElementBuilder toBuilder();
	
	static RestructuringElement.RestructuringElementBuilder builder() {
		return new RestructuringElement.RestructuringElementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RestructuringElement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RestructuringElement> getType() {
		return RestructuringElement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.class, getPartialExerciseAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringElementBuilder extends RestructuringElement, RestructuringEvent.RestructuringEventBuilder {
		RestructuringElement.RestructuringElementBuilder setPartialExerciseAmount(Money partialExerciseAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.MoneyBuilder.class, getPartialExerciseAmount());
		}
		

		RestructuringElement.RestructuringElementBuilder prune();
	}

	/*********************** Immutable Implementation of RestructuringElement  ***********************/
	class RestructuringElementImpl extends RestructuringEvent.RestructuringEventImpl implements RestructuringElement {
		
		protected RestructuringElementImpl(RestructuringElement.RestructuringElementBuilder builder) {
			super(builder);
		}
		
		@Override
		public RestructuringElement build() {
			return this;
		}
		
		@Override
		public RestructuringElement.RestructuringElementBuilder toBuilder() {
			RestructuringElement.RestructuringElementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RestructuringElement.RestructuringElementBuilder builder) {
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
			return "RestructuringElement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RestructuringElement  ***********************/
	class RestructuringElementBuilderImpl extends RestructuringEvent.RestructuringEventBuilderImpl  implements RestructuringElement.RestructuringElementBuilder {
	
	
		public RestructuringElementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partialExerciseAmount")
		public RestructuringElement.RestructuringElementBuilder setPartialExerciseAmount(Money partialExerciseAmount) {
			this.partialExerciseAmount = partialExerciseAmount==null?null:partialExerciseAmount.toBuilder();
			return this;
		}
		
		@Override
		public RestructuringElement build() {
			return new RestructuringElement.RestructuringElementImpl(this);
		}
		
		@Override
		public RestructuringElement.RestructuringElementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringElement.RestructuringElementBuilder prune() {
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
		public RestructuringElement.RestructuringElementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RestructuringElement.RestructuringElementBuilder o = (RestructuringElement.RestructuringElementBuilder) other;
			
			
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
			return "RestructuringElementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

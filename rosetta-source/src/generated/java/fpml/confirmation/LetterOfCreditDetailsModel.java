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
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder;
import fpml.confirmation.LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilderImpl;
import fpml.confirmation.LetterOfCreditDetailsModel.LetterOfCreditDetailsModelImpl;
import fpml.confirmation.LetterOfCreditSummary;
import fpml.confirmation.meta.LetterOfCreditDetailsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model used to reference an L/C by either identifier, summary or full L/C details, within various notifications.
 * @version ${project.version}
 */
@RosettaDataType(value="LetterOfCreditDetailsModel", builder=LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilderImpl.class, version="${project.version}")
public interface LetterOfCreditDetailsModel extends RosettaModelObject {

	LetterOfCreditDetailsModelMeta metaData = new LetterOfCreditDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A deal summary structure.
	 */
	FacilityContractIdentifier getLetterOfCreditIdentifier();
	/**
	 * A facility summary structure.
	 */
	LetterOfCreditSummary getLetterOfCreditSummary();
	/**
	 * A facility summary structure.
	 */
	LetterOfCredit getLetterOfCredit();

	/*********************** Build Methods  ***********************/
	LetterOfCreditDetailsModel build();
	
	LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder toBuilder();
	
	static LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder builder() {
		return new LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCreditDetailsModel> getType() {
		return LetterOfCreditDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, FacilityContractIdentifier.class, getLetterOfCreditIdentifier());
		processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.class, getLetterOfCreditSummary());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditDetailsModelBuilder extends LetterOfCreditDetailsModel, RosettaModelObjectBuilder {
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getLetterOfCreditIdentifier();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCreditIdentifier(FacilityContractIdentifier letterOfCreditIdentifier);
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary);
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCredit(LetterOfCredit letterOfCredit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
			processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.LetterOfCreditSummaryBuilder.class, getLetterOfCreditSummary());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditDetailsModel  ***********************/
	class LetterOfCreditDetailsModelImpl implements LetterOfCreditDetailsModel {
		private final FacilityContractIdentifier letterOfCreditIdentifier;
		private final LetterOfCreditSummary letterOfCreditSummary;
		private final LetterOfCredit letterOfCredit;
		
		protected LetterOfCreditDetailsModelImpl(LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder builder) {
			this.letterOfCreditIdentifier = ofNullable(builder.getLetterOfCreditIdentifier()).map(f->f.build()).orElse(null);
			this.letterOfCreditSummary = ofNullable(builder.getLetterOfCreditSummary()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public FacilityContractIdentifier getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public LetterOfCredit getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public LetterOfCreditDetailsModel build() {
			return this;
		}
		
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder toBuilder() {
			LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder builder) {
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
			ofNullable(getLetterOfCreditSummary()).ifPresent(builder::setLetterOfCreditSummary);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditDetailsModel {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of LetterOfCreditDetailsModel  ***********************/
	class LetterOfCreditDetailsModelBuilderImpl implements LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder {
	
		protected FacilityContractIdentifier.FacilityContractIdentifierBuilder letterOfCreditIdentifier;
		protected LetterOfCreditSummary.LetterOfCreditSummaryBuilder letterOfCreditSummary;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
	
		public LetterOfCreditDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier() {
			FacilityContractIdentifier.FacilityContractIdentifierBuilder result;
			if (letterOfCreditIdentifier!=null) {
				result = letterOfCreditIdentifier;
			}
			else {
				result = letterOfCreditIdentifier = FacilityContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary() {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder result;
			if (letterOfCreditSummary!=null) {
				result = letterOfCreditSummary;
			}
			else {
				result = letterOfCreditSummary = LetterOfCreditSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit() {
			LetterOfCredit.LetterOfCreditBuilder result;
			if (letterOfCredit!=null) {
				result = letterOfCredit;
			}
			else {
				result = letterOfCredit = LetterOfCredit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCreditIdentifier(FacilityContractIdentifier letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = letterOfCreditIdentifier==null?null:letterOfCreditIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary) {
			this.letterOfCreditSummary = letterOfCreditSummary==null?null:letterOfCreditSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCredit")
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder setLetterOfCredit(LetterOfCredit letterOfCredit) {
			this.letterOfCredit = letterOfCredit==null?null:letterOfCredit.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditDetailsModel build() {
			return new LetterOfCreditDetailsModel.LetterOfCreditDetailsModelImpl(this);
		}
		
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder prune() {
			if (letterOfCreditIdentifier!=null && !letterOfCreditIdentifier.prune().hasData()) letterOfCreditIdentifier = null;
			if (letterOfCreditSummary!=null && !letterOfCreditSummary.prune().hasData()) letterOfCreditSummary = null;
			if (letterOfCredit!=null && !letterOfCredit.prune().hasData()) letterOfCredit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLetterOfCreditIdentifier()!=null && getLetterOfCreditIdentifier().hasData()) return true;
			if (getLetterOfCreditSummary()!=null && getLetterOfCreditSummary().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder o = (LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder) other;
			
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			merger.mergeRosetta(getLetterOfCreditSummary(), o.getLetterOfCreditSummary(), this::setLetterOfCreditSummary);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditDetailsModelBuilder {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}

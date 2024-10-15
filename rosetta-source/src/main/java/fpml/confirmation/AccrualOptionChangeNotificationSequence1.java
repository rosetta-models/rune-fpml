package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1BuilderImpl;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Impl;
import fpml.confirmation.LcOptionChange;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.meta.AccrualOptionChangeNotificationSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="AccrualOptionChangeNotificationSequence1", builder=AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1BuilderImpl.class, version="${project.version}")
public interface AccrualOptionChangeNotificationSequence1 extends RosettaModelObject {

	AccrualOptionChangeNotificationSequence1Meta metaData = new AccrualOptionChangeNotificationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	LcOptionChange getLcOptionChange();
	List<? extends LetterOfCredit> getLetterOfCredit();

	/*********************** Build Methods  ***********************/
	AccrualOptionChangeNotificationSequence1 build();
	
	AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder toBuilder();
	
	static AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder builder() {
		return new AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualOptionChangeNotificationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualOptionChangeNotificationSequence1> getType() {
		return AccrualOptionChangeNotificationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lcOptionChange"), processor, LcOptionChange.class, getLcOptionChange());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualOptionChangeNotificationSequence1Builder extends AccrualOptionChangeNotificationSequence1, RosettaModelObjectBuilder {
		LcOptionChange.LcOptionChangeBuilder getOrCreateLcOptionChange();
		LcOptionChange.LcOptionChangeBuilder getLcOptionChange();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit(int _index);
		List<? extends LetterOfCredit.LetterOfCreditBuilder> getLetterOfCredit();
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder setLcOptionChange(LcOptionChange lcOptionChange);
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(LetterOfCredit letterOfCredit0);
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(LetterOfCredit letterOfCredit1, int _idx);
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(List<? extends LetterOfCredit> letterOfCredit2);
		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder setLetterOfCredit(List<? extends LetterOfCredit> letterOfCredit3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lcOptionChange"), processor, LcOptionChange.LcOptionChangeBuilder.class, getLcOptionChange());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of AccrualOptionChangeNotificationSequence1  ***********************/
	class AccrualOptionChangeNotificationSequence1Impl implements AccrualOptionChangeNotificationSequence1 {
		private final LcOptionChange lcOptionChange;
		private final List<? extends LetterOfCredit> letterOfCredit;
		
		protected AccrualOptionChangeNotificationSequence1Impl(AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder builder) {
			this.lcOptionChange = ofNullable(builder.getLcOptionChange()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcOptionChange")
		public LcOptionChange getLcOptionChange() {
			return lcOptionChange;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public List<? extends LetterOfCredit> getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence1 build() {
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder toBuilder() {
			AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder builder) {
			ofNullable(getLcOptionChange()).ifPresent(builder::setLcOptionChange);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionChangeNotificationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(lcOptionChange, _that.getLcOptionChange())) return false;
			if (!ListEquals.listEquals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lcOptionChange != null ? lcOptionChange.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotificationSequence1 {" +
				"lcOptionChange=" + this.lcOptionChange + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualOptionChangeNotificationSequence1  ***********************/
	class AccrualOptionChangeNotificationSequence1BuilderImpl implements AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder {
	
		protected LcOptionChange.LcOptionChangeBuilder lcOptionChange;
		protected List<LetterOfCredit.LetterOfCreditBuilder> letterOfCredit = new ArrayList<>();
	
		public AccrualOptionChangeNotificationSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lcOptionChange")
		public LcOptionChange.LcOptionChangeBuilder getLcOptionChange() {
			return lcOptionChange;
		}
		
		@Override
		public LcOptionChange.LcOptionChangeBuilder getOrCreateLcOptionChange() {
			LcOptionChange.LcOptionChangeBuilder result;
			if (lcOptionChange!=null) {
				result = lcOptionChange;
			}
			else {
				result = lcOptionChange = LcOptionChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		public List<? extends LetterOfCredit.LetterOfCreditBuilder> getLetterOfCredit() {
			return letterOfCredit;
		}
		
		public LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit(int _index) {
		
			if (letterOfCredit==null) {
				this.letterOfCredit = new ArrayList<>();
			}
			LetterOfCredit.LetterOfCreditBuilder result;
			return getIndex(letterOfCredit, _index, () -> {
						LetterOfCredit.LetterOfCreditBuilder newLetterOfCredit = LetterOfCredit.builder();
						return newLetterOfCredit;
					});
		}
		
		@Override
		@RosettaAttribute("lcOptionChange")
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder setLcOptionChange(LcOptionChange lcOptionChange) {
			this.lcOptionChange = lcOptionChange==null?null:lcOptionChange.toBuilder();
			return this;
		}
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(LetterOfCredit letterOfCredit) {
			if (letterOfCredit!=null) this.letterOfCredit.add(letterOfCredit.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(LetterOfCredit letterOfCredit, int _idx) {
			getIndex(this.letterOfCredit, _idx, () -> letterOfCredit.toBuilder());
			return this;
		}
		@Override 
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder addLetterOfCredit(List<? extends LetterOfCredit> letterOfCredits) {
			if (letterOfCredits != null) {
				for (LetterOfCredit toAdd : letterOfCredits) {
					this.letterOfCredit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("letterOfCredit")
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder setLetterOfCredit(List<? extends LetterOfCredit> letterOfCredits) {
			if (letterOfCredits == null)  {
				this.letterOfCredit = new ArrayList<>();
			}
			else {
				this.letterOfCredit = letterOfCredits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AccrualOptionChangeNotificationSequence1 build() {
			return new AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Impl(this);
		}
		
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder prune() {
			if (lcOptionChange!=null && !lcOptionChange.prune().hasData()) lcOptionChange = null;
			letterOfCredit = letterOfCredit.stream().filter(b->b!=null).<LetterOfCredit.LetterOfCreditBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLcOptionChange()!=null && getLcOptionChange().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder o = (AccrualOptionChangeNotificationSequence1.AccrualOptionChangeNotificationSequence1Builder) other;
			
			merger.mergeRosetta(getLcOptionChange(), o.getLcOptionChange(), this::setLcOptionChange);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::getOrCreateLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualOptionChangeNotificationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(lcOptionChange, _that.getLcOptionChange())) return false;
			if (!ListEquals.listEquals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lcOptionChange != null ? lcOptionChange.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeNotificationSequence1Builder {" +
				"lcOptionChange=" + this.lcOptionChange + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}

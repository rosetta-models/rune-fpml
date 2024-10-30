package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Borrowing;
import fpml.confirmation.validation.BorrowingTypeFormatValidator;
import fpml.confirmation.validation.BorrowingValidator;
import fpml.confirmation.validation.exists.BorrowingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Borrowing.class)
public class BorrowingMeta implements RosettaMetaData<Borrowing> {

	@Override
	public List<Validator<? super Borrowing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Borrowing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Borrowing> validator() {
		return new BorrowingValidator();
	}

	@Override
	public Validator<? super Borrowing> typeFormatValidator() {
		return new BorrowingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Borrowing, Set<String>> onlyExistsValidator() {
		return new BorrowingOnlyExistsValidator();
	}
}
